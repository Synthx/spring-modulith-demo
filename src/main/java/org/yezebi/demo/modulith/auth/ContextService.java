package org.yezebi.demo.modulith.auth;

import java.util.Optional;

public interface ContextService {
  Optional<String> getCurrentUserId();

  Optional<CurrentUser> getCurrentUser();

  CurrentUser getCurrentUserOrThrow();
}
