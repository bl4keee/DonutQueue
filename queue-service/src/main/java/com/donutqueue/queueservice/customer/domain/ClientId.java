package com.donutqueue.queueservice.customer.domain;

import lombok.NonNull;
import lombok.Value;

/**
 * @author bl4kee
 * @since 27.11.2022
 */
@Value
public class ClientId {

  public static ClientId ONE = ClientId.of(1);

  @NonNull
  private final Integer value;

  public static ClientId of(int value) {
    return new ClientId(value);
  }

  public boolean isPremiumClient() {
    return this.value < 1000;
  }

  public boolean isRegularClient() {
    return this.value >= 1000;
  }

  public boolean isGreaterThan(ClientId clientId) {
    return this.value.compareTo(clientId.value) > 0;
  }

  public boolean isLessThan(ClientId clientId) {
    return this.value.compareTo(clientId.value) < 0;
  }

  public boolean isEqualTo(ClientId clientId) {
    return this.value.compareTo(clientId.value) == 0;
  }
}
