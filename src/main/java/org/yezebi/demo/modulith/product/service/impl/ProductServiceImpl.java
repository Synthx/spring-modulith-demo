package org.yezebi.demo.modulith.product.service.impl;

import java.util.Map;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.yezebi.demo.modulith.auth.entity.User;
import org.yezebi.demo.modulith.auth.service.ContextService;
import org.yezebi.demo.modulith.email.EmailService;
import org.yezebi.demo.modulith.email.model.Email;
import org.yezebi.demo.modulith.email.model.EmailTemplate;
import org.yezebi.demo.modulith.product.dto.request.CreateProductRequest;
import org.yezebi.demo.modulith.product.dto.response.ProductResponse;
import org.yezebi.demo.modulith.product.entity.Product;
import org.yezebi.demo.modulith.product.entity.ProductCategory;
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
    final User user = contextService.getCurrentUserOrThrow();
    final Optional<ProductCategory> category =
        productCategoryService.findById(request.categoryId());
    if (category.isEmpty()) {
      throw new IllegalArgumentException("Category not found");
    }

    Product product = Product.from(request);
    product.setCategory(category.get());
    product.setUser(user);

    product = repository.save(product);

    final Email email =
        new Email(
            user.getEmail(), EmailTemplate.PRODUCT_CREATED, Map.of("product", product.getName()));
    emailService.send(email);

    return ProductResponse.from(product);
  }
}
