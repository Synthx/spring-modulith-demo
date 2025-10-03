package org.yezebi.demo.modulith.auth.service;

import java.util.Optional;
import org.yezebi.demo.modulith.auth.dto.request.CreateUserRequest;
import org.yezebi.demo.modulith.auth.dto.response.UserResponse;

public interface AuthService {
  UserResponse create(final CreateUserRequest request);

  Optional<UserResponse> findCurrent();

  UserResponse updateEmail(final String email);
}
