package org.yezebi.demo.modulith.email.service;

import org.yezebi.demo.modulith.auth.entity.User;
import org.yezebi.demo.modulith.product.entity.Product;

public interface EmailService {
  void sendProductCreated(final User user, final Product product);
}
