package com.donutqueue.queueservice.customer.application.port.in;

import com.donutqueue.queueservice.customer.domain.ClientId;
import com.donutqueue.queueservice.customer.domain.Order.Quantity;
import com.donutqueue.util.validation.SelfValidating;
import lombok.EqualsAndHashCode;
import lombok.Value;
import javax.validation.constraints.NotNull;

/**
 * @author bl4kee
 * @since 27.11.2022
 */
@Value
@EqualsAndHashCode(callSuper = false)
public class AddOrderCommand extends SelfValidating<AddOrderCommand> {

  @NotNull
  private final Quantity quantity;

  @NotNull
  private final ClientId clientId;

  public AddOrderCommand(ClientId clientId, Quantity quantity) {
    this.clientId = clientId;
    this.quantity = quantity;
    //this.validateSelf();
  }
}
