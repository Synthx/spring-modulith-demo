package org.yezebi.demo.modulith.core.exception;

import lombok.Getter;
import org.springframework.boot.logging.LogLevel;
import org.springframework.http.HttpStatus;
import org.springframework.lang.Nullable;
import org.springframework.util.ObjectUtils;

@Getter
public abstract class RestException extends RuntimeException {
  private final String message;
  @Nullable private final Object[] params;

  public RestException(final String message) {
    super(message);
    this.message = message;
    this.params = null;
  }

  public RestException(final String message, final Throwable throwable) {
    super(message, throwable);
    this.message = message;
    this.params = null;
  }

  public RestException(final String message, @Nullable final Object... params) {
    super(message);
    this.message = message;
    this.params = params;
  }

  @Override
  public String getMessage() {
    final StringBuilder stringBuilder = new StringBuilder();
    if (!ObjectUtils.isEmpty(params)) {
      stringBuilder.append(String.format(message, params));
    } else {
      stringBuilder.append(message);
    }

    return stringBuilder.toString();
  }

  public abstract HttpStatus getStatus();

  public abstract LogLevel getLogLevel();
}
