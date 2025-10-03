package org.yezebi.demo.modulith.auth.service;

import com.google.firebase.auth.UserRecord;

public interface FirebaseService {
  UserRecord createUser(final String email, final String password, final String username);

  UserRecord updateUserEmail(final String id, final String email);
}
