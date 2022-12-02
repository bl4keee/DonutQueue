package com.donutqueue.queueservice.shared.adapter.persistence;

import com.donutqueue.api.exceptions.DuplicatedOrderException;
import com.donutqueue.api.queue.domain.OrderDTO;
import com.donutqueue.api.queue.domain.OrderExtendedDTO;
import com.donutqueue.queueservice.customer.application.port.in.AddOrderCommand;
import com.donutqueue.queueservice.customer.application.port.out.AddOrderPort;
import com.donutqueue.queueservice.customer.application.port.out.CancelOrderPort;
import com.donutqueue.queueservice.customer.application.port.out.CheckOrderPort;
import com.donutqueue.queueservice.employee.application.port.in.GetNextDeliveryPort;
import com.donutqueue.queueservice.management.application.port.out.GetOrdersPort;
import com.donutqueue.util.annotations.PersistenceAdapter;
import lombok.AllArgsConstructor;
import java.util.ArrayList;
import java.util.List;

/**
 * @author bl4kee
 * @since 27.11.2022
 */

@PersistenceAdapter
@AllArgsConstructor
class OrderQueueAdapter implements AddOrderPort, GetOrdersPort, CancelOrderPort, CheckOrderPort, GetNextDeliveryPort {

  private final OrderQueueService orderQueueService;
  private final OrderQueueItemMapper orderQueueItemMapper;

  @Override
  public OrderDTO addOrderToQueue(AddOrderCommand orderCommand) {
    return orderQueueItemMapper.mapToOrderDTO(orderQueueService.addOrderToQueue(orderCommand));
  }

  @Override
  public List<OrderExtendedDTO> getAllOrdersInQueue() {
    return orderQueueService.getAllOrdersWithDetails().stream()
        .map(orderQueueItemMapper::mapToExtendedOrderDTO)
        .toList();
  }

  @Override
  public void cancelOrder(int clientId) {
    orderQueueService.cancelOrder(clientId);
  }

  @Override
  public OrderExtendedDTO checkOrder(int clientId) {
    return orderQueueItemMapper.mapToExtendedOrderDTO(orderQueueService.getOrderWithDetails(clientId));
  }

  @Override
  public List<OrderDTO> getNextDelivery() {
    return orderQueueService.retrieveNextDelivery().stream()
        .map(orderQueueItemMapper::mapToOrderDTO)
        .toList();
  }
}
