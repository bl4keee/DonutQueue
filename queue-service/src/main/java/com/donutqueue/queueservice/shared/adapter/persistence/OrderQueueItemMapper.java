package com.donutqueue.queueservice.shared.adapter.persistence;

import com.donutqueue.api.queue.domain.OrderDTO;
import com.donutqueue.api.queue.domain.OrderExtendedDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/**
 * @author bl4kee
 * @since 28.11.2022
 */
@Mapper(componentModel = "spring")
public interface OrderQueueItemMapper {

  @Mappings({
      @Mapping(source = "clientId.value", target = "clientId"),
      @Mapping(source = "quantityOfDonuts.value", target = "quantityOfDonuts")
  })
  OrderDTO mapToOrderDTO(OrderQueueItem orderQueueItem);

  @Mappings({
      @Mapping(source = "position", target = "queuePosition"),
      @Mapping(source = "clientId.value", target = "clientId"),
      @Mapping(source = "waitTime", target = "approximateWaitTime"),
      @Mapping(source = "quantityOfDonuts.value", target = "quantityOfDonuts")
  })
  OrderExtendedDTO mapToExtendedOrderDTO(OrderQueueItem orderQueueItem);
}
