package com.donutqueue.queueservice.management.application.service;

import com.donutqueue.api.queue.domain.OrderExtendedDTO;
import com.donutqueue.queueservice.management.application.port.in.GetOrdersUseCase;
import com.donutqueue.queueservice.management.application.port.out.GetOrdersPort;
import com.donutqueue.util.annotations.UseCase;
import lombok.RequiredArgsConstructor;
import java.util.List;

/**
 * @author bl4kee
 * @since 28.11.2022
 */
@UseCase
@RequiredArgsConstructor
public class GetOrdersService implements GetOrdersUseCase {

  private final GetOrdersPort getOrdersPort;

  @Override
  public List<OrderExtendedDTO> getAllOrdersInQueue() {
    return getOrdersPort.getAllOrdersInQueue();
  }
}
