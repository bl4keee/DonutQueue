package com.donutqueue.queueservice.shared.adapter.persistence;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author bl4kee
 * @since 30.11.2022
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderProperties {

  private int maxCartQuantity;
  private double minutesBetweenEveryPickup;
  private double secondsBetweenEveryPickup;
}
