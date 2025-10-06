package org.yezebi.demo.modulith.product.service.impl;

import java.util.Map;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.yezebi.demo.modulith.auth.ContextService;
import org.yezebi.demo.modulith.auth.CurrentUser;
import org.yezebi.demo.modulith.email.EmailService;
import org.yezebi.demo.modulith.email.model.Email;
import org.yezebi.demo.modulith.email.model.EmailTemplate;
import org.yezebi.demo.modulith.product.dto.request.CreateProductRequest;
import org.yezebi.demo.modulith.product.dto.response.ProductResponse;
import org.yezebi.demo.modulith.product.entity.ProductCategoryEntity;
import org.yezebi.demo.modulith.product.entity.ProductEntity;
import org.yezebi.demo.modulith.product.repository.ProductRepository;
import org.yezebi.demo.modulith.product.service.ProductCategoryService;
import org.yezebi.demo.modulith.product.service.ProductService;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
  private final ProductRepository repository;
  private final ProductCategoryService productCategoryService;
  private final EmailService emailService;
  private final ContextService contextService;

  @Override
  public Page<ProductResponse> findAll(final Pageable pageable) {
    return repository.findAllBy(pageable).map(ProductResponse::from);
  }

  @Override
  @Transactional
  public ProductResponse create(final CreateProductRequest request) {
    final CurrentUser user = contextService.getCurrentUserOrThrow();

    final Optional<ProductCategoryEntity> category =
        productCategoryService.findById(request.categoryId());
    if (category.isEmpty()) {
      throw new IllegalArgumentException("Category not found");
    }

    ProductEntity product = ProductEntity.from(request);
    product.setCategory(category.get());
    product.setUserId(user.id());

    product = repository.save(product);

    final Email email =
        new Email(
            user.email(), EmailTemplate.PRODUCT_CREATED, Map.of("product", product.getName()));
    emailService.send(email);

    return ProductResponse.from(product);
  }
}
