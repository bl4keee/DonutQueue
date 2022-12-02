package com.donutqueue.api.queue.domain;

/**
 * @author bl4kee
 * @since 30.11.2022
 */
public class OrderExtendedDTO {

  private int clientId;
  private int queuePosition;
  private int quantityOfDonuts;
  private double approximateWaitTime;

  public OrderExtendedDTO() {
  }

  public OrderExtendedDTO(int clientId, int queuePosition, int quantityOfDonuts, double approximateWaitTime) {
    this.clientId = clientId;
    this.queuePosition = queuePosition;
    this.quantityOfDonuts = quantityOfDonuts;
    this.approximateWaitTime = approximateWaitTime;
  }

  public int getClientId() {
    return clientId;
  }

  public void setClientId(int clientId) {
    this.clientId = clientId;
  }

  public int getQuantityOfDonuts() {
    return quantityOfDonuts;
  }

  public void setQuantityOfDonuts(int quantityOfDonuts) {
    this.quantityOfDonuts = quantityOfDonuts;
  }

  public double getApproximateWaitTime() {
    return approximateWaitTime;
  }

  public void setApproximateWaitTime(double approximateWaitTime) {
    this.approximateWaitTime = approximateWaitTime;
  }

  public int getQueuePosition() {
    return queuePosition;
  }

  public void setQueuePosition(int queuePosition) {
    this.queuePosition = queuePosition;
  }
}
