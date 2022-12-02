package com.donutqueue.queueservice.shared.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author bl4kee
 * @since 30.11.2022
 */
@Data
@ConfigurationProperties(prefix = "order")
public class OrderConfigurationProperties {

  private int maxCartQuantity;
  private int minutesBetweenEveryPickup;
  private int secondsBetweenEveryPickup;
}
