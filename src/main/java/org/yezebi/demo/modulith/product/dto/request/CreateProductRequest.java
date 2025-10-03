package org.yezebi.demo.modulith.product.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.UUID;
import org.hibernate.validator.constraints.Length;

public record CreateProductRequest(
    @NotBlank @Length(min = 2, max = 255) String name,
    @NotNull @Min(0) BigDecimal price,
    @NotNull UUID categoryId) {}
