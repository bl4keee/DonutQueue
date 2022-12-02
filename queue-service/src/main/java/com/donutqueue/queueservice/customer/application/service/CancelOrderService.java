package com.donutqueue.queueservice.customer.application.service;

import com.donutqueue.queueservice.customer.application.port.in.CancelOrderUseCase;
import com.donutqueue.queueservice.customer.application.port.out.CancelOrderPort;
import com.donutqueue.util.annotations.UseCase;
import lombok.RequiredArgsConstructor;

/**
 * @author bl4kee
 * @since 28.11.2022
 */
@UseCase
@RequiredArgsConstructor
public class CancelOrderService implements CancelOrderUseCase {

  private final CancelOrderPort cancelOrderPort;

  @Override
  public void cancelOrder(int clientId) {
    cancelOrderPort.cancelOrder(clientId);
  }
}
