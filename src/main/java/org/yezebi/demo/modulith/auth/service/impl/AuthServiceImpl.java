package org.yezebi.demo.modulith.auth.service.impl;

import com.google.firebase.auth.UserRecord;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.yezebi.demo.modulith.auth.ContextService;
import org.yezebi.demo.modulith.auth.dto.request.CreateUserRequest;
import org.yezebi.demo.modulith.auth.dto.response.UserResponse;
import org.yezebi.demo.modulith.auth.entity.UserEntity;
import org.yezebi.demo.modulith.auth.repository.UserRepository;
import org.yezebi.demo.modulith.auth.service.AuthService;
import org.yezebi.demo.modulith.auth.service.FirebaseService;

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
    UserEntity user = UserEntity.from(record);

    user = repository.save(user);

    return UserResponse.from(user);
  }

  @Override
  public Optional<UserResponse> findCurrent() {
    return contextService.getCurrentUserId().flatMap(repository::findById).map(UserResponse::from);
  }

  @Override
  public UserResponse updateEmail(final String email) {
    return null;
  }
}
