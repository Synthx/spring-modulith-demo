package org.yezebi.demo.modulith.dto.response;

import lombok.Builder;
import org.yezebi.demo.modulith.entity.User;

@Builder
public record UserResponse(String id, String email, String username) {
  public static UserResponse from(final User user) {
    return UserResponse.builder()
        .id(user.getId())
        .email(user.getEmail())
        .username(user.getUsername())
        .build();
  }
}
