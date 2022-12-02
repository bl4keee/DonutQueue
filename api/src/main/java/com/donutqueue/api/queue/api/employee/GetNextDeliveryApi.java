package com.donutqueue.api.queue.api.employee;

import com.donutqueue.api.queue.domain.OrderDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * @author bl4kee
 * @since 27.11.2022
 */
@Tag(name = "GetNextDelivery", description = "REST API for retrieving next delivery as a employee.")
public interface GetNextDeliveryApi {

  @Operation(summary = "${api.employee.delivery.summary}")
  @GetMapping("/delivery")
  List<OrderDTO> getNextDelivery();
}
