package org.yezebi.demo.modulith.product.dto.request;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

public record CreateProductCategoryRequest(@NotBlank @Length(min = 2, max = 255) String name) {}
