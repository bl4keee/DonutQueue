package com.donutqueue.api.queue.domain;


/**
 * @author bl4kee
 * @since 27.11.2022
 */
public class OrderDTO {

  private int clientId;
  private int quantityOfDonuts;

  public OrderDTO() {
  }

  public OrderDTO(int clientId, int quantityOfDonuts) {
    this.clientId = clientId;
    this.quantityOfDonuts = quantityOfDonuts;
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
}
