package com.donutqueue.queueservice.customer.adapter.in.web;

import com.donutqueue.api.queue.api.customer.CheckOrderApi;
import com.donutqueue.api.queue.domain.OrderExtendedDTO;
import com.donutqueue.queueservice.customer.application.port.in.CheckOrderUseCase;
import com.donutqueue.util.annotations.WebAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author bl4kee
 * @since 27.11.2022
 */

@WebAdapter
@RestController
@RequiredArgsConstructor
class CheckOrderController implements CheckOrderApi {

  private final CheckOrderUseCase checkOrderUseCase;

  @Override
  public OrderExtendedDTO checkOrder(int clientId) {
    return checkOrderUseCase.checkOrder(clientId);
  }
}
