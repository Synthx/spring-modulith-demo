package org.yezebi.demo.modulith.product.service.impl;

import java.util.Optional;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.yezebi.demo.modulith.product.dto.request.CreateProductCategoryRequest;
import org.yezebi.demo.modulith.product.dto.response.ProductCategoryResponse;
import org.yezebi.demo.modulith.product.entity.ProductCategoryEntity;
import org.yezebi.demo.modulith.product.repository.ProductCategoryRepository;
import org.yezebi.demo.modulith.product.service.ProductCategoryService;

@Service
@RequiredArgsConstructor
public class ProductCategoryServiceImpl implements ProductCategoryService {
  private final ProductCategoryRepository repository;

  @Override
  public Page<ProductCategoryResponse> findAll(final Pageable pageable) {
    return repository.findAll(pageable).map(ProductCategoryResponse::from);
  }

  @Override
  @Transactional
  public ProductCategoryResponse create(final CreateProductCategoryRequest request) {
    ProductCategoryEntity category = ProductCategoryEntity.from(request);

    category = repository.save(category);

    return ProductCategoryResponse.from(category);
  }

  @Override
  public Optional<ProductCategoryEntity> findById(final UUID id) {
    return repository.findById(id);
  }
}
