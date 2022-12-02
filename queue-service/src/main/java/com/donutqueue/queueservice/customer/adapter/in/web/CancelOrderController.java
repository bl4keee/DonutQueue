package com.donutqueue.queueservice.customer.adapter.in.web;

import com.donutqueue.api.queue.api.customer.CancelOrderApi;
import com.donutqueue.queueservice.customer.application.port.in.CancelOrderUseCase;
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
class CancelOrderController implements CancelOrderApi {

  private final CancelOrderUseCase cancelOrderUseCase;

  @Override
  public void cancelOrder(int clientId) {
    cancelOrderUseCase.cancelOrder(clientId);
  }
}
