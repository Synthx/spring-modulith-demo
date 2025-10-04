package org.yezebi.demo.modulith.email.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.yezebi.demo.modulith.email.EmailService;
import org.yezebi.demo.modulith.email.model.Email;
import org.yezebi.demo.modulith.email.properties.EmailProperties;

@Slf4j
@Service
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService {
  final EmailProperties properties;

  @Async
  @Override
  public void send(final Email email) {
    log.info(
        "Sending {} email to {} for product {} created with {}.",
        email.template(),
        email.to(),
        email.params().get("product"),
        properties.from());
  }
}
