package com.donutqueue.queueservice.customer.application.service;

import com.donutqueue.api.queue.domain.OrderExtendedDTO;
import com.donutqueue.queueservice.customer.application.port.in.CheckOrderUseCase;
import com.donutqueue.queueservice.customer.application.port.out.CheckOrderPort;
import com.donutqueue.util.annotations.UseCase;
import lombok.RequiredArgsConstructor;

/**
 * @author bl4kee
 * @since 28.11.2022
 */
@UseCase
@RequiredArgsConstructor
public class CheckOrderService implements CheckOrderUseCase {

  private final CheckOrderPort checkOrderPort;

  @Override
  public OrderExtendedDTO checkOrder(int clientId) {
    return checkOrderPort.checkOrder(clientId);
  }
}
