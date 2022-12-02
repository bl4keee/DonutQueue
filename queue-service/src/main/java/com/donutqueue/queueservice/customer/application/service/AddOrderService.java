package com.donutqueue.queueservice.customer.application.service;

import com.donutqueue.api.exceptions.MaxClientIdThresholdExceededException;
import com.donutqueue.api.exceptions.MinClientIdThresholdExceededException;
import com.donutqueue.api.queue.domain.OrderDTO;
import com.donutqueue.queueservice.customer.application.port.in.AddOrderCommand;
import com.donutqueue.queueservice.customer.application.port.in.AddOrderUseCase;
import com.donutqueue.queueservice.customer.application.port.out.AddOrderPort;
import com.donutqueue.util.annotations.UseCase;
import lombok.RequiredArgsConstructor;

/**
 * @author bl4kee
 * @since 27.11.2022
 */
@UseCase
@RequiredArgsConstructor
public class AddOrderService implements AddOrderUseCase {

  private final AddOrderPort addOrderPort;
  private final ClientIdProperties clientIdProperties;

  @Override
  public OrderDTO addOrderToQueue(AddOrderCommand orderCommand) {
    checkClientIdentifierThreshold(orderCommand);
    return addOrderPort.addOrderToQueue(orderCommand);
  }

  private void checkClientIdentifierThreshold(AddOrderCommand orderCommand) {
    if (orderCommand.getClientId().isLessThan(clientIdProperties.getMinimumClientIdThreshold())) {
      throw new MinClientIdThresholdExceededException(
          orderCommand.getClientId().getValue(),
          clientIdProperties.getMinimumClientIdThreshold().getValue());
    } else if (orderCommand.getClientId().isGreaterThan(clientIdProperties.getMaximumClientIdThreshold())) {
      throw new MaxClientIdThresholdExceededException(
          orderCommand.getClientId().getValue(),
          clientIdProperties.getMaximumClientIdThreshold().getValue());
    }
  }
}
