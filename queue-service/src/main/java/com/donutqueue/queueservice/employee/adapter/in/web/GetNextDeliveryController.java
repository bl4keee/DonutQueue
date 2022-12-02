package com.donutqueue.queueservice.employee.adapter.in.web;

import com.donutqueue.api.queue.api.employee.GetNextDeliveryApi;
import com.donutqueue.api.queue.domain.OrderDTO;
import com.donutqueue.queueservice.employee.application.port.out.GetNextDeliveryUseCase;
import com.donutqueue.util.annotations.WebAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author bl4kee
 * @since 29.11.2022
 */
@WebAdapter
@RestController
@RequiredArgsConstructor
class GetNextDeliveryController implements GetNextDeliveryApi {

  private final GetNextDeliveryUseCase getNextDeliveryUseCase;

  @Override
  public List<OrderDTO> getNextDelivery() {
    return getNextDeliveryUseCase.getNextDelivery();
  }
}
