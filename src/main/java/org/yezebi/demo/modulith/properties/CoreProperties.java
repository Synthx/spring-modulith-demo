package org.yezebi.demo.modulith.properties;

import jakarta.validation.constraints.NotBlank;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

@Validated
@ConfigurationProperties(prefix = "app.core")
public record CoreProperties(@NotBlank String projectId) {}
