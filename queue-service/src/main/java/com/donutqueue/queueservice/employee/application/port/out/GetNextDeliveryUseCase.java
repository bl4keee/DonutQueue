package com.donutqueue.queueservice.employee.application.port.out;

import com.donutqueue.api.queue.domain.OrderDTO;

import java.util.List;

/**
 * @author bl4kee
 * @since 29.11.2022
 */
public interface GetNextDeliveryUseCase {

  List<OrderDTO> getNextDelivery();
}
