package com.donutqueue.queueservice.customer.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Value;

/**
 * @author bl4kee
 * @since 27.11.2022
 */
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Order {

  @Getter
  private final ClientId clientId;

  @Getter
  private final Quantity quantity;

  @Value
  public static class Quantity {
    int value;
  }
}
