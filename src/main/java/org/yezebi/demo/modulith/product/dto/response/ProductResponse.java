package org.yezebi.demo.modulith.product.dto.response;

import java.util.UUID;
import lombok.Builder;
import org.yezebi.demo.modulith.product.entity.ProductEntity;

@Builder
public record ProductResponse(UUID id, String name) {
  public static ProductResponse from(final ProductEntity product) {
    return ProductResponse.builder().id(product.getId()).name(product.getName()).build();
  }
}
