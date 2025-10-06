package org.yezebi.demo.modulith.service;

import java.util.Optional;
import java.util.UUID;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.yezebi.demo.modulith.dto.request.CreateProductCategoryRequest;
import org.yezebi.demo.modulith.dto.response.ProductCategoryResponse;
import org.yezebi.demo.modulith.entity.ProductCategory;

public interface ProductCategoryService {
  Page<ProductCategoryResponse> findAll(final Pageable pageable);

  ProductCategoryResponse create(final CreateProductCategoryRequest request);

  Optional<ProductCategory> findById(final UUID id);
}
