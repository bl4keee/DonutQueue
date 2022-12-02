package com.donutqueue.api.exceptions;

/**
 * @author bl4kee
 * @since 27.11.2022
 */
public class MaxClientIdThresholdExceededException extends RuntimeException {

  public MaxClientIdThresholdExceededException(int actualValue, int maxThreshold) {
    super(String.format("Maximum threshold of clientId was exceeded: Tried to perform operation for clientId %s, but threshold is %s!", actualValue, maxThreshold));
  }
}
