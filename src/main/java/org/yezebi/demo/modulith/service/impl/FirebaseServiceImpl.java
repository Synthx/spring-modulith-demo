package org.yezebi.demo.modulith.service.impl;

import com.google.firebase.FirebaseException;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.UserRecord;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.yezebi.demo.modulith.exception.InternalErrorException;
import org.yezebi.demo.modulith.service.FirebaseService;

@Service
@RequiredArgsConstructor
public class FirebaseServiceImpl implements FirebaseService {
  private final FirebaseAuth firebaseAuth;

  @Override
  public UserRecord createUser(final String email, final String password, final String username) {
    try {
      final UserRecord.CreateRequest request =
          new UserRecord.CreateRequest()
              .setEmail(email)
              .setPassword(password)
              .setDisplayName(username);

      return firebaseAuth.createUser(request);
    } catch (final FirebaseException e) {
      throw new InternalErrorException("Cannot create firebase user", e);
    }
  }

  @Override
  public UserRecord updateUserEmail(final String id, final String email) {
    try {
      final UserRecord.UpdateRequest request = new UserRecord.UpdateRequest(id).setEmail(email);

      return firebaseAuth.updateUser(request);
    } catch (final FirebaseException e) {
      throw new InternalErrorException("Cannot update user email", e);
    }
  }
}
