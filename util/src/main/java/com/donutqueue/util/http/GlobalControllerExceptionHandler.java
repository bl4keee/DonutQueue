package com.donutqueue.util.http;

import com.donutqueue.api.exceptions.DuplicatedOrderException;
import com.donutqueue.api.exceptions.MaxClientIdThresholdExceededException;
import com.donutqueue.api.exceptions.MinClientIdThresholdExceededException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static org.springframework.http.HttpStatus.*;

/**
 * @author bl4kee
 * @since 27.11.2022
 */
@RestControllerAdvice
class GlobalControllerExceptionHandler {

  private static final Logger logger = LoggerFactory.getLogger(GlobalControllerExceptionHandler.class);

  @ResponseStatus(BAD_REQUEST)
  @ExceptionHandler(DuplicatedOrderException.class)
  public @ResponseBody HttpErrorInfo handleDuplicatedOrderException(ServerHttpRequest request, DuplicatedOrderException ex) {
    return createHttpErrorInfo(BAD_REQUEST, request, ex);
  }

  @ResponseStatus(UNPROCESSABLE_ENTITY)
  @ExceptionHandler(MaxClientIdThresholdExceededException.class)
  public @ResponseBody HttpErrorInfo handleMaxClientIdThresholdExceededException(ServerHttpRequest request, MaxClientIdThresholdExceededException ex) {
    return createHttpErrorInfo(UNPROCESSABLE_ENTITY, request, ex);
  }

  @ResponseStatus(UNPROCESSABLE_ENTITY)
  @ExceptionHandler(MinClientIdThresholdExceededException.class)
  public @ResponseBody HttpErrorInfo handleMinClientIdThresholdExceededException(ServerHttpRequest request, MinClientIdThresholdExceededException ex) {
    return createHttpErrorInfo(UNPROCESSABLE_ENTITY, request, ex);
  }

  private HttpErrorInfo createHttpErrorInfo(HttpStatus httpStatus, ServerHttpRequest request, Exception ex) {
    final String path = request.getPath().pathWithinApplication().value();
    final String message = ex.getMessage();

    logger.debug("Returning HTTP status: {} for path: {}, message: {}", httpStatus, path, message);
    return new HttpErrorInfo(httpStatus, path, message);
  }
}
