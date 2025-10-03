package org.yezebi.demo.modulith.auth.controller.impl;

import jakarta.validation.Valid;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RestController;
import org.yezebi.demo.modulith.auth.controller.AuthController;
import org.yezebi.demo.modulith.auth.dto.request.CreateUserRequest;
import org.yezebi.demo.modulith.auth.dto.response.UserResponse;
import org.yezebi.demo.modulith.auth.service.AuthService;

@RestController
@RequiredArgsConstructor
public class AuthControllerImpl implements AuthController {
  private final AuthService authService;

  @Override
  public UserResponse create(@Valid final CreateUserRequest request) {
    return authService.create(request);
  }

  @Override
  @PreAuthorize("isAuthenticated()")
  public Optional<UserResponse> findCurrent() {
    return authService.findCurrent();
  }
}
