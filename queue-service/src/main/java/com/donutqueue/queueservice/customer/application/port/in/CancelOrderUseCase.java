package com.donutqueue.queueservice.customer.application.port.in;

/**
 * @author bl4kee
 * @since 28.11.2022
 */
public interface CancelOrderUseCase {

  void cancelOrder(int clientId);
}
