package org.yezebi.demo.modulith.auth.service.impl;

import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;
import org.yezebi.demo.modulith.auth.ContextService;
import org.yezebi.demo.modulith.auth.CurrentUser;
import org.yezebi.demo.modulith.auth.repository.UserRepository;
import org.yezebi.demo.modulith.core.exception.NotFoundException;

@Service
@RequiredArgsConstructor
public class ContextServiceImpl implements ContextService {
  private final UserRepository repository;

  @Override
  public Optional<String> getCurrentUserId() {
    return Optional.ofNullable(SecurityContextHolder.getContext())
        .map(SecurityContext::getAuthentication)
        .filter(Authentication::isAuthenticated)
        .map(Authentication::getPrincipal)
        .map(Jwt.class::cast)
        .map(Jwt::getSubject);
  }

  @Override
  public Optional<CurrentUser> getCurrentUser() {
    return getCurrentUserId().flatMap(repository::findById).map(CurrentUser::from);
  }

  @Override
  public CurrentUser getCurrentUserOrThrow() {
    return getCurrentUser().orElseThrow(() -> new NotFoundException("Current user not found"));
  }
}
