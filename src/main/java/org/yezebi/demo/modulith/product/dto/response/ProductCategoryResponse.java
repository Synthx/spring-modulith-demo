package org.yezebi.demo.modulith.product.dto.response;

import java.util.UUID;
import lombok.Builder;
import org.yezebi.demo.modulith.product.entity.ProductCategory;

@Builder
public record ProductCategoryResponse(UUID id, String name) {
  public static ProductCategoryResponse from(final ProductCategory category) {
    return ProductCategoryResponse.builder().id(category.getId()).name(category.getName()).build();
  }
}
