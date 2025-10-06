package org.yezebi.demo.modulith.service;

import org.yezebi.demo.modulith.entity.Product;
import org.yezebi.demo.modulith.entity.User;

public interface EmailService {
  void sendProductCreated(final User user, final Product product);
}
