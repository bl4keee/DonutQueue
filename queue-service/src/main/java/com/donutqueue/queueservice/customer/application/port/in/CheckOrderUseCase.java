package com.donutqueue.queueservice.customer.application.port.in;

import com.donutqueue.api.queue.domain.OrderExtendedDTO;

/**
 * @author bl4kee
 * @since 28.11.2022
 */
public interface CheckOrderUseCase {

  OrderExtendedDTO checkOrder(int clientId);
}
