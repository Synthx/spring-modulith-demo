package org.yezebi.demo.modulith.email.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.yezebi.demo.modulith.auth.entity.User;
import org.yezebi.demo.modulith.email.properties.EmailProperties;
import org.yezebi.demo.modulith.email.service.EmailService;
import org.yezebi.demo.modulith.product.entity.Product;

@Slf4j
@Service
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService {
  final EmailProperties properties;

  @Async
  @Override
  public void sendProductCreated(final User user, final Product product) {
    log.info(
        "Sending email to {} for product {} created with {}.",
        user.getEmail(),
        product.getId(),
        properties.from());
  }
}
