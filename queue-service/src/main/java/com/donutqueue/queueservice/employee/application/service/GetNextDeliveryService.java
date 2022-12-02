package com.donutqueue.queueservice.employee.application.service;

import com.donutqueue.api.queue.domain.OrderDTO;
import com.donutqueue.queueservice.employee.application.port.in.GetNextDeliveryPort;
import com.donutqueue.queueservice.employee.application.port.out.GetNextDeliveryUseCase;
import com.donutqueue.util.annotations.UseCase;
import lombok.RequiredArgsConstructor;
import java.util.List;


/**
 * @author bl4kee
 * @since 29.11.2022
 */
@UseCase
@RequiredArgsConstructor
public class GetNextDeliveryService implements GetNextDeliveryUseCase {

  private final GetNextDeliveryPort getNextDeliveryPort;

  @Override
  public List<OrderDTO> getNextDelivery() {
    return getNextDeliveryPort.getNextDelivery();
  }
}
