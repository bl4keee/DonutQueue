package com.donutqueue.api.queue.api.management;


import com.donutqueue.api.queue.domain.OrderExtendedDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * @author bl4kee
 * @since 27.11.2022
 */
@Tag(name = "GetOrders", description = "REST API getting the list of all order in the queue as a manager.")
public interface GetOrdersApi {

  @Operation(summary = "${api.manager.orders.summary}")
  @GetMapping(value = "/orders", produces = "application/json")
  List<OrderExtendedDTO> getAllOrdersInQueue();
}
