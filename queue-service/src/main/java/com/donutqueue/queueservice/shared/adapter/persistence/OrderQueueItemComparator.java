package com.donutqueue.queueservice.shared.adapter.persistence;

import java.util.Comparator;

/**
 * @author bl4kee
 * @since 28.11.2022
 */
public class OrderQueueItemComparator implements Comparator<OrderQueueItem> {

  @Override
  public int compare(OrderQueueItem firstOrderQueueItem, OrderQueueItem secondOrderQueueItem) {
    if (firstOrderQueueItem.getClientId().isEqualTo(secondOrderQueueItem.getClientId())) {
      return 0;
    } else if (firstOrderQueueItem.getClientId().isRegularClient() && secondOrderQueueItem.getClientId().isPremiumClient()) {
      return 1;
    } else {
      return -1;
    }
  }
}
