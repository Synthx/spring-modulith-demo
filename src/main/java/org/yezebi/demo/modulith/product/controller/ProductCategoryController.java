package org.yezebi.demo.modulith.product.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.yezebi.demo.modulith.product.dto.request.CreateProductCategoryRequest;
import org.yezebi.demo.modulith.product.dto.response.ProductCategoryResponse;

@RequestMapping("api/products/categories")
public interface ProductCategoryController {
  @GetMapping
  Page<ProductCategoryResponse> findAll(final Pageable pageable);

  @PostMapping
  ProductCategoryResponse create(@RequestBody final CreateProductCategoryRequest request);
}
