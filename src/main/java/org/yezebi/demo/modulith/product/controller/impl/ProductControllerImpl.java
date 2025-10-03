package org.yezebi.demo.modulith.product.controller.impl;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RestController;
import org.yezebi.demo.modulith.product.controller.ProductController;
import org.yezebi.demo.modulith.product.dto.request.CreateProductRequest;
import org.yezebi.demo.modulith.product.dto.response.ProductResponse;
import org.yezebi.demo.modulith.product.service.ProductService;

@RestController
@RequiredArgsConstructor
public class ProductControllerImpl implements ProductController {
  private final ProductService productService;

  @Override
  public Page<ProductResponse> findAll(final Pageable pageable) {
    return productService.findAll(pageable);
  }

  @Override
  @PreAuthorize("isAuthenticated()")
  public ProductResponse create(@Valid final CreateProductRequest request) {
    return productService.create(request);
  }
}
