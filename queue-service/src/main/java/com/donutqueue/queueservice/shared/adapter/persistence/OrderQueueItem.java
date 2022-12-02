package com.donutqueue.queueservice.shared.adapter.persistence;

import com.donutqueue.queueservice.customer.domain.ClientId;
import com.donutqueue.queueservice.customer.domain.Order.Quantity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author bl4kee
 * @since 27.11.2022
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderQueueItem {

  private ClientId clientId;
  private Quantity quantityOfDonuts;
  private double waitTime;
  private int position;
}
