package com.donutqueue.queueservice.management.application.port.in;

import com.donutqueue.api.queue.domain.OrderExtendedDTO;

import java.util.List;

/**
 * @author bl4kee
 * @since 28.11.2022
 */
public interface GetOrdersUseCase {

  List<OrderExtendedDTO> getAllOrdersInQueue();
}
