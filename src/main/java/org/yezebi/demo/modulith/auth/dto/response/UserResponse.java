package org.yezebi.demo.modulith.auth.dto.response;

import lombok.Builder;
import org.yezebi.demo.modulith.auth.entity.UserEntity;

@Builder
public record UserResponse(String id, String email, String username) {
  public static UserResponse from(final UserEntity user) {
    return UserResponse.builder()
        .id(user.getId())
        .email(user.getEmail())
        .username(user.getUsername())
        .build();
  }
}
