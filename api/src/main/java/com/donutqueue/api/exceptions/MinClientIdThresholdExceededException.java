package com.donutqueue.api.exceptions;

/**
 * @author bl4kee
 * @since 27.11.2022
 */
public class MinClientIdThresholdExceededException extends RuntimeException {

  public MinClientIdThresholdExceededException(int actualValue, int minThreshold) {
    super(String.format("Minimum threshold of clientId was exceeded: Tried to perform operation for clientId %s, but threshold is %s!", actualValue, minThreshold));
  }

}
