package org.yezebi.demo.modulith.email.model;

import java.util.Map;
import lombok.Builder;

@Builder
public record Email(String to, EmailTemplate template, Map<String, Object> params) {
  public static Email from(final String to, final EmailTemplate template) {
    return Email.builder().to(to).template(template).params(Map.of()).build();
  }
}
