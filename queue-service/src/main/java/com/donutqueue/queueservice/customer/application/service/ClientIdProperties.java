package com.donutqueue.queueservice.customer.application.service;

import com.donutqueue.queueservice.customer.domain.ClientId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author bl4kee
 * @since 27.11.2022
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientIdProperties {

  private ClientId minimumClientIdThreshold;

  private ClientId maximumClientIdThreshold;
}
