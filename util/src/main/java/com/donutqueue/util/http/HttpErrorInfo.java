package com.donutqueue.util.http;

import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

/**
 * @author bl4kee
 * @since 27.11.2022
 */
public class HttpErrorInfo {

  private final String path;
  private final String message;
  private final HttpStatus httpStatus;
  private final ZonedDateTime timestamp;

  public HttpErrorInfo() {
    timestamp = null;
    this.httpStatus = null;
    this.path = null;
    this.message = null;
  }

  public HttpErrorInfo(HttpStatus httpStatus, String path, String message) {
    timestamp = ZonedDateTime.now();
    this.httpStatus = httpStatus;
    this.path = path;
    this.message = message;
  }

  public String getPath() {
    return path;
  }

  public String getMessage() {
    return message;
  }

  public ZonedDateTime getTimestamp() {
    return timestamp;
  }

  public int getStatus() {
    return httpStatus.value();
  }

  public String getError() {
    return httpStatus.getReasonPhrase();
  }

}
