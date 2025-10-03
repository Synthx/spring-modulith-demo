package org.yezebi.demo.modulith.product.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.yezebi.demo.modulith.product.dto.request.CreateProductRequest;
import org.yezebi.demo.modulith.product.dto.response.ProductResponse;

public interface ProductService {
  Page<ProductResponse> findAll(final Pageable pageable);

  ProductResponse create(final CreateProductRequest request);
}
