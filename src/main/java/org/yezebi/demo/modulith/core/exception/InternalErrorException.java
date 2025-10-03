package org.yezebi.demo.modulith.core.exception;

import org.springframework.boot.logging.LogLevel;
import org.springframework.http.HttpStatus;

public class InternalErrorException extends RestException {
  public InternalErrorException(final String message, final Throwable throwable) {
    super(message, throwable);
  }

  @Override
  public HttpStatus getStatus() {
    return HttpStatus.INTERNAL_SERVER_ERROR;
  }

  @Override
  public LogLevel getLogLevel() {
    return LogLevel.ERROR;
  }
}
