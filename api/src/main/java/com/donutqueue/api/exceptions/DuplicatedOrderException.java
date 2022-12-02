package com.donutqueue.api.exceptions;

/**
 * @author bl4kee
 * @since 27.11.2022
 */
public class DuplicatedOrderException extends RuntimeException {

  public DuplicatedOrderException(int clientId) {
    super(String.format("Client of id %s has already placed an order!", clientId));
  }
}
