package com.donutqueue.queueservice.management.application.port.out;

import com.donutqueue.api.queue.domain.OrderExtendedDTO;

import java.util.List;

/**
 * @author bl4kee
 * @since 28.11.2022
 */
public interface GetOrdersPort {

  List<OrderExtendedDTO> getAllOrdersInQueue();

}
