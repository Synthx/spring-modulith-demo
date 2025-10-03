package org.yezebi.demo.modulith.core.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.yezebi.demo.modulith.core.dto.ExceptionResponse;
import org.yezebi.demo.modulith.core.exception.RestException;

@Slf4j
@ControllerAdvice
@RequiredArgsConstructor
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
  @ExceptionHandler(RestException.class)
  public ResponseEntity<ExceptionResponse> handleKiaRestException(
      final RestException exception, final WebRequest request) {
    switch (exception.getLogLevel()) {
      case WARN -> log.warn(exception.getMessage(), exception.getCause());
      case ERROR -> log.error(exception.getMessage(), exception.getCause());
      default -> log.debug(exception.getMessage(), exception.getCause());
    }

    final ExceptionResponse response = ExceptionResponse.from(exception, request);

    return ResponseEntity.status(exception.getStatus()).body(response);
  }
}
