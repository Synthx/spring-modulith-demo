package org.yezebi.demo.modulith.product.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.yezebi.demo.modulith.product.dto.request.CreateProductRequest;
import org.yezebi.demo.modulith.product.dto.response.ProductResponse;

@RequestMapping("api/products")
public interface ProductController {
  @GetMapping
  Page<ProductResponse> findAll(final Pageable pageable);

  @PostMapping
  ProductResponse create(@RequestBody final CreateProductRequest request);
}
