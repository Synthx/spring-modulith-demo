package org.yezebi.demo.modulith.service.impl;

import com.google.firebase.auth.UserRecord;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.yezebi.demo.modulith.dto.request.CreateUserRequest;
import org.yezebi.demo.modulith.dto.response.UserResponse;
import org.yezebi.demo.modulith.entity.User;
import org.yezebi.demo.modulith.repository.UserRepository;
import org.yezebi.demo.modulith.service.AuthService;
import org.yezebi.demo.modulith.service.ContextService;
import org.yezebi.demo.modulith.service.FirebaseService;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
  private final FirebaseService firebaseService;
  private final ContextService contextService;
  private final UserRepository repository;

  @Override
  @Transactional
  public UserResponse create(final CreateUserRequest request) {
    final UserRecord record =
        firebaseService.createUser(request.email(), request.password(), request.username());
    User user = User.from(record);

    user = repository.save(user);

    return UserResponse.from(user);
  }

  @Override
  public Optional<UserResponse> findCurrent() {
    return contextService.getCurrentUser().map(UserResponse::from);
  }

  @Override
  public UserResponse updateEmail(final String email) {
    return null;
  }
}
