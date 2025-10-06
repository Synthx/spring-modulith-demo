package org.yezebi.demo.modulith.auth;

import lombok.Builder;
import org.yezebi.demo.modulith.auth.entity.UserEntity;

@Builder
public record CurrentUser(String id, String email, String username) {
  public static CurrentUser from(final UserEntity user) {
    return CurrentUser.builder()
        .id(user.getId())
        .email(user.getEmail())
        .username(user.getUsername())
        .build();
  }
}
