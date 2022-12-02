package com.donutqueue.queueservice.customer.application.port.out;

import com.donutqueue.api.queue.domain.OrderExtendedDTO;

/**
 * @author bl4kee
 * @since 28.11.2022
 */
public interface CheckOrderPort {

  OrderExtendedDTO checkOrder(int clientId);
}
