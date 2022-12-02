package com.donutqueue.api.queue.api.customer;

import com.donutqueue.api.queue.domain.OrderExtendedDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author bl4kee
 * @since 27.11.2022
 */
@Tag(name = "CheckOrder", description = "REST API for checking an order as a customer.")
public interface CheckOrderApi {

  @Operation(summary = "${api.customer.check-order.summary}")
  @GetMapping(value = "/order/{clientId}")
  OrderExtendedDTO checkOrder(@PathVariable("clientId") int clientId);
}
