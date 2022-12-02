package com.donutqueue.queueservice.customer.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author bl4kee
 * @since 27.11.2022
 */
@Data
@ConfigurationProperties(prefix = "client")
public class ClientConfigurationProperties {

  private int maxClientIdThreshold;
  private int minClientIdThreshold;
}
