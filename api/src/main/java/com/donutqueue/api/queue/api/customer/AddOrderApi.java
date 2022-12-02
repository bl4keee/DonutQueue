package com.donutqueue.api.queue.api.customer;

import com.donutqueue.api.queue.domain.OrderDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author bl4kee
 * @since 27.11.2022
 */
@Tag(name = "AddOrder", description = "REST API for adding new order as a customer.")
public interface AddOrderApi {

  @Operation(summary = "${api.customer.add-order.summary}")
  @PostMapping(value = "/order", produces = "application/json")
  OrderDTO addOrderToQueue(@RequestParam("clientId") int clientId, @RequestParam("quantity") int quantity);
}
