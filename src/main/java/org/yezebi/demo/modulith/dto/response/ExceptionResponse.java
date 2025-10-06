package org.yezebi.demo.modulith.dto.response;

import java.time.LocalDateTime;
import lombok.Builder;
import org.springframework.web.context.request.WebRequest;
import org.yezebi.demo.modulith.exception.RestException;

@Builder
public record ExceptionResponse(
    LocalDateTime timestamp, int status, String error, String message, String path) {
  public static ExceptionResponse from(final RestException exception, final WebRequest request) {
    return ExceptionResponse.builder()
        .timestamp(LocalDateTime.now())
        .error(exception.getStatus().getReasonPhrase())
        .status(exception.getStatus().value())
        .message(exception.getMessage())
        .path(request.getContextPath())
        .build();
  }
}
