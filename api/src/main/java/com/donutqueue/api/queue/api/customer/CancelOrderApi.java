package com.donutqueue.api.queue.api.customer;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author bl4kee
 * @since 27.11.2022
 */
@Tag(name = "CancelOrder", description = "REST API for canceling an order as a customer.")
public interface CancelOrderApi {

  @Operation(
      summary = "${api.customer.cancel-order.summary}")
  @DeleteMapping(value = "/order/{clientId}")
  void cancelOrder(@PathVariable("clientId") int clientId);
}
