package com.donutqueue.queueservice.customer.application.port.out;

import com.donutqueue.api.queue.domain.OrderDTO;
import com.donutqueue.queueservice.customer.application.port.in.AddOrderCommand;

/**
 * @author bl4kee
 * @since 27.11.2022
 */
public interface AddOrderPort {

  OrderDTO addOrderToQueue(AddOrderCommand orderCommand);
}
