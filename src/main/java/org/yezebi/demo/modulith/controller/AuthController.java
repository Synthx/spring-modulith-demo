package org.yezebi.demo.modulith.controller;

import java.util.Optional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.yezebi.demo.modulith.dto.request.CreateUserRequest;
import org.yezebi.demo.modulith.dto.response.UserResponse;

@RequestMapping("api/auth")
public interface AuthController {
  @PostMapping
  UserResponse create(@RequestBody final CreateUserRequest request);

  @GetMapping("me")
  Optional<UserResponse> findCurrent();
}
