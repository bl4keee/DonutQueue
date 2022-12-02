package com.donutqueue.queueservice.shared.adapter.persistence;

import com.donutqueue.api.exceptions.DuplicatedOrderException;
import com.donutqueue.queueservice.customer.application.port.in.AddOrderCommand;
import com.donutqueue.queueservice.customer.domain.ClientId;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;
import java.util.function.Function;

import static java.lang.Math.round;

/**
 * @author bl4kee
 * @since 30.11.2022
 */
@Component
@AllArgsConstructor
class OrderQueueService {

  private final OrderProperties orderProperties;

  protected final PriorityQueue<OrderQueueItem> queueOfOrders = new PriorityQueue<>(new OrderQueueItemComparator());

  protected OrderQueueItem addOrderToQueue(AddOrderCommand orderCommand) {
    OrderQueueItem orderQueueItem = new OrderQueueItem();

    if (queueOfOrders.stream().anyMatch(queueItem -> queueItem.getClientId().isEqualTo(orderCommand.getClientId()))) {
      throw new DuplicatedOrderException(orderCommand.getClientId().getValue());
    } else {
      orderQueueItem.setClientId(orderCommand.getClientId());
      orderQueueItem.setQuantityOfDonuts(orderCommand.getQuantity());
      queueOfOrders.add(orderQueueItem);
    }
    return orderQueueItem;
  }

  protected OrderQueueItem getOrderWithDetails(int clientId) {
    OrderQueueItem orderToReturn = queueOfOrders.stream()
        .filter(orderQueueItem -> orderQueueItem.getClientId().isEqualTo(ClientId.of(clientId)))
        .findFirst().orElseThrow(NoSuchElementException::new);

    double approxWaitTime = getApproxOrderWaitTime(clientId);
    int positionOfOrder = getPositionBasedOnPreviousOrders(clientId);

    orderToReturn.setWaitTime(approxWaitTime);
    orderToReturn.setPosition(positionOfOrder);
    return orderToReturn;
  }

  protected List<OrderQueueItem> retrieveNextDelivery() {
    List<OrderQueueItem> cartOfOrders = new ArrayList<>();

    for (OrderQueueItem order : queueOfOrders) {
      if (cartOfOrders.size() <= orderProperties.getMaxCartQuantity()) {
        cartOfOrders.add(order);
      }
    }

    return cartOfOrders;
  }

  protected List<OrderQueueItem> getAllOrdersWithDetails() {
    return queueOfOrders.stream()
        .map(provideOrderPositionAndWaitTime)
        .toList();
  }

  protected void cancelOrder(int clientId) {
    queueOfOrders.removeIf(orderQueueItem -> orderQueueItem.getClientId().getValue() == clientId);
  }

  private List<OrderQueueItem> premiumOrdersInQueue() {
    return queueOfOrders.stream().filter(orderQueueItem -> orderQueueItem.getClientId().isPremiumClient()).toList();
  }

  private List<OrderQueueItem> regularOrdersInQueue() {
    return queueOfOrders.stream().filter(orderQueueItem -> orderQueueItem.getClientId().isRegularClient()).toList();
  }

  private double calculateOrderWaitTime(int quantityOfDonuts) {
    double amount = (double) quantityOfDonuts / orderProperties.getMaxCartQuantity();
    return round(amount * orderProperties.getSecondsBetweenEveryPickup() + orderProperties.getSecondsBetweenEveryPickup());
  }

  private final Function<OrderQueueItem, OrderQueueItem> provideOrderPositionAndWaitTime = orderQueueItem -> {
    double approxWaitTime = getApproxOrderWaitTime(orderQueueItem.getClientId().getValue());
    int positionOfOrder = getPositionBasedOnPreviousOrders(orderQueueItem.getClientId().getValue());
    orderQueueItem.setWaitTime(approxWaitTime);
    orderQueueItem.setPosition(positionOfOrder);
    return orderQueueItem;
  };

  private double getApproxOrderWaitTime(int clientId) {
    if (ClientId.of(clientId).isPremiumClient()) {
      int quantityOfDonutsFromPremiumOrders = getTotalQuantityOfDonutsFromPremiumOrders(clientId);
      return calculateOrderWaitTime(quantityOfDonutsFromPremiumOrders);
    } else {
      int quantityOfDonutsFromRegularOrders = getTotalQuantityOfDonuts(regularOrdersInQueue(), clientId);
      int quantityOfDonutsFromPremiumOrders = getTotalQuantityOfDonutsFromPremiumOrders(null);
      return calculateOrderWaitTime(quantityOfDonutsFromRegularOrders + quantityOfDonutsFromPremiumOrders);
    }
  }

  private int getPositionBasedOnPreviousOrders(int clientId) {
    int orderPosition = 1;
    for (OrderQueueItem order : queueOfOrders.stream().toList()) {
      if (!order.getClientId().isEqualTo(ClientId.of(clientId))) {
        orderPosition = orderPosition + 1;
      } else {
        break;
      }
    }
    return orderPosition;
  }

  private int getTotalQuantityOfDonutsFromPremiumOrders(Integer clientId) {
    if (clientId != null) {
      return getTotalQuantityOfDonuts(premiumOrdersInQueue(), clientId);
    } else {
      return premiumOrdersInQueue().stream()
          .mapToInt(premiumOrder -> premiumOrder.getQuantityOfDonuts().getValue())
          .sum();
    }
  }

  private int getTotalQuantityOfDonuts(List<OrderQueueItem> orders, int clientId) {
    int quantityOfDonuts = 0;
    for (OrderQueueItem order : orders) {
      do {
        quantityOfDonuts = quantityOfDonuts + order.getQuantityOfDonuts().getValue();
      } while (order.getClientId().isEqualTo(ClientId.of(clientId)) && orders.size() > 1);
    }
    return quantityOfDonuts;
  }

}
