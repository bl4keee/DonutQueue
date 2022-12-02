package com.donutqueue.queueservice.customer.adapter.in.web;

import com.donutqueue.api.queue.api.customer.AddOrderApi;
import com.donutqueue.api.queue.domain.OrderDTO;
import com.donutqueue.queueservice.customer.application.port.in.AddOrderCommand;
import com.donutqueue.queueservice.customer.application.port.in.AddOrderUseCase;
import com.donutqueue.queueservice.customer.domain.ClientId;
import com.donutqueue.queueservice.customer.domain.Order.Quantity;
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
class AddOrderController implements AddOrderApi {

  private final AddOrderUseCase addOrderUseCase;

  @Override
  public OrderDTO addOrderToQueue(int clientId, int quantity) {
    AddOrderCommand orderCommand = new AddOrderCommand(ClientId.of(clientId), new Quantity(quantity));
    return addOrderUseCase.addOrderToQueue(orderCommand);
  }
}
