package com.donutqueue.queueservice.customer.application.port.out;

/**
 * @author bl4kee
 * @since 28.11.2022
 */
public interface CancelOrderPort {

  void cancelOrder(int clientId);
}
