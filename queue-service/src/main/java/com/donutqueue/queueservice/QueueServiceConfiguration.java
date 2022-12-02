package com.donutqueue.queueservice;

import com.donutqueue.queueservice.customer.application.service.ClientIdProperties;
import com.donutqueue.queueservice.customer.config.ClientConfigurationProperties;
import com.donutqueue.queueservice.customer.domain.ClientId;
import com.donutqueue.queueservice.shared.adapter.persistence.OrderProperties;
import com.donutqueue.queueservice.shared.config.OrderConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author bl4kee
 * @since 27.11.2022
 */
@Configuration
@EnableConfigurationProperties({ClientConfigurationProperties.class, OrderConfigurationProperties.class})
public class QueueServiceConfiguration {

  @Bean
  public ClientIdProperties clientIdProperties(ClientConfigurationProperties clientConfigurationProperties) {
    return new ClientIdProperties(
        ClientId.of(clientConfigurationProperties.getMinClientIdThreshold()),
        ClientId.of(clientConfigurationProperties.getMaxClientIdThreshold()));
  }

  @Bean
  public OrderProperties orderProperties(OrderConfigurationProperties orderConfigurationProperties) {
    return new OrderProperties(
        orderConfigurationProperties.getMaxCartQuantity(),
        orderConfigurationProperties.getMinutesBetweenEveryPickup(),
        orderConfigurationProperties.getSecondsBetweenEveryPickup());
  }
}
