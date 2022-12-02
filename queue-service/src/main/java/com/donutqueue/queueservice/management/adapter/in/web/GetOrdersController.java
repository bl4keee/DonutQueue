package com.donutqueue.queueservice.management.adapter.in.web;

import com.donutqueue.api.queue.api.management.GetOrdersApi;
import com.donutqueue.api.queue.domain.OrderExtendedDTO;
import com.donutqueue.queueservice.management.application.port.in.GetOrdersUseCase;
import com.donutqueue.util.annotations.WebAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author bl4kee
 * @since 28.11.2022
 */
@WebAdapter
@RestController
@RequiredArgsConstructor
class GetOrdersController implements GetOrdersApi {

  private final GetOrdersUseCase getOrdersUseCase;

  @Override
  public List<OrderExtendedDTO> getAllOrdersInQueue() {
    return getOrdersUseCase.getAllOrdersInQueue();
  }
}
