package org.yezebi.demo.modulith.dto.request;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

public record CreateUserRequest(
    @NotBlank @Length(max = 255) String email,
    @NotBlank String password,
    @NotBlank @Length(min = 4, max = 255) String username) {}
