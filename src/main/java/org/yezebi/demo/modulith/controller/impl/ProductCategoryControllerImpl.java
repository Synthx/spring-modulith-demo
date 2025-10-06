package org.yezebi.demo.modulith.controller.impl;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RestController;
import org.yezebi.demo.modulith.controller.ProductCategoryController;
import org.yezebi.demo.modulith.dto.request.CreateProductCategoryRequest;
import org.yezebi.demo.modulith.dto.response.ProductCategoryResponse;
import org.yezebi.demo.modulith.service.ProductCategoryService;

@RestController
@RequiredArgsConstructor
public class ProductCategoryControllerImpl implements ProductCategoryController {
  private final ProductCategoryService service;

  @Override
  public Page<ProductCategoryResponse> findAll(final Pageable pageable) {
    return service.findAll(pageable);
  }

  @Override
  @PreAuthorize("isAuthenticated()")
  public ProductCategoryResponse create(@Valid final CreateProductCategoryRequest request) {
    return service.create(request);
  }
}
