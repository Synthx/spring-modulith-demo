package org.yezebi.demo.modulith.product.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.yezebi.demo.modulith.core.entity.Auditable;
import org.yezebi.demo.modulith.product.dto.request.CreateProductRequest;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "products")
public class ProductEntity extends Auditable {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @Column(nullable = false)
  private String name;

  @Column(nullable = false)
  private BigDecimal price;

  @ManyToOne(fetch = FetchType.LAZY)
  private ProductCategoryEntity category;

  @Column(nullable = false)
  private String userId;

  public static ProductEntity from(final CreateProductRequest request) {
    return ProductEntity.builder().name(request.name()).price(request.price()).build();
  }
}
