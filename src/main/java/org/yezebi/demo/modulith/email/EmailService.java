package org.yezebi.demo.modulith.email;

import org.yezebi.demo.modulith.email.model.Email;

public interface EmailService {
  void send(final Email email);
}
