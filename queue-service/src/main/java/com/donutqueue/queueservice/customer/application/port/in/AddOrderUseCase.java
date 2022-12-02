package com.donutqueue.queueservice.customer.application.port.in;

import com.donutqueue.api.queue.domain.OrderDTO;

/**
 * @author bl4kee
 * @since 27.11.2022
 */
public interface AddOrderUseCase {

  OrderDTO addOrderToQueue(AddOrderCommand addOrderCommand);
}
