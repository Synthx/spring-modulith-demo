package org.yezebi.demo.modulith.core.exception;

import org.springframework.boot.logging.LogLevel;
import org.springframework.http.HttpStatus;
import org.springframework.lang.Nullable;

public class NotFoundException extends RestException {
  public NotFoundException(final String message) {
    super(message);
  }

  public NotFoundException(final String message, @Nullable final Object... params) {
    super(message, params);
  }

  @Override
  public HttpStatus getStatus() {
    return HttpStatus.NOT_FOUND;
  }

  @Override
  public LogLevel getLogLevel() {
    return LogLevel.WARN;
  }
}
