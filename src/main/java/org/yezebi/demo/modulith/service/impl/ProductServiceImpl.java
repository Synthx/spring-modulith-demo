package org.yezebi.demo.modulith.service.impl;

import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.yezebi.demo.modulith.dto.request.CreateProductRequest;
import org.yezebi.demo.modulith.dto.response.ProductResponse;
import org.yezebi.demo.modulith.entity.Product;
import org.yezebi.demo.modulith.entity.ProductCategory;
import org.yezebi.demo.modulith.entity.User;
import org.yezebi.demo.modulith.repository.ProductRepository;
import org.yezebi.demo.modulith.service.ContextService;
import org.yezebi.demo.modulith.service.EmailService;
import org.yezebi.demo.modulith.service.ProductCategoryService;
import org.yezebi.demo.modulith.service.ProductService;

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

    emailService.sendProductCreated(user, product);

    return ProductResponse.from(product);
  }
}
