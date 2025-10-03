package org.yezebi.demo.modulith.product.dto.response;

import java.util.UUID;
import lombok.Builder;
import org.yezebi.demo.modulith.product.entity.Product;

@Builder
public record ProductResponse(UUID id, String name, String publisher) {
  public static ProductResponse from(final Product product) {
    return ProductResponse.builder()
        .id(product.getId())
        .name(product.getName())
        .publisher(product.getUser().getUsername())
        .build();
  }
}
