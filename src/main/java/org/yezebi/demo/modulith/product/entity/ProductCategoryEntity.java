package org.yezebi.demo.modulith.product.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.yezebi.demo.modulith.core.entity.Auditable;
import org.yezebi.demo.modulith.product.dto.request.CreateProductCategoryRequest;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "product_categories")
public class ProductCategoryEntity extends Auditable {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @Column(nullable = false)
  private String name;

  public static ProductCategoryEntity from(final CreateProductCategoryRequest request) {
    return ProductCategoryEntity.builder().name(request.name()).build();
  }
}
