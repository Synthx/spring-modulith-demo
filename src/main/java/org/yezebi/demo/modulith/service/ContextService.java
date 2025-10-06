package org.yezebi.demo.modulith.service;

import java.util.Optional;
import org.yezebi.demo.modulith.entity.User;

public interface ContextService {
  Optional<User> getCurrentUser();

  User getCurrentUserOrThrow();
}
