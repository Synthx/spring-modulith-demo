package org.yezebi.demo.modulith.service;

import java.util.Optional;
import org.yezebi.demo.modulith.dto.request.CreateUserRequest;
import org.yezebi.demo.modulith.dto.response.UserResponse;

public interface AuthService {
  UserResponse create(final CreateUserRequest request);

  Optional<UserResponse> findCurrent();

  UserResponse updateEmail(final String email);
}
