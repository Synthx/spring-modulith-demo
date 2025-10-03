package org.yezebi.demo.modulith.auth.service;

import java.util.Optional;
import org.yezebi.demo.modulith.auth.entity.User;

public interface ContextService {
  Optional<User> getCurrentUser();

  User getCurrentUserOrThrow();
}
