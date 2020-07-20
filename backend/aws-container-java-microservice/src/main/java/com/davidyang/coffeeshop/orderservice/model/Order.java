package com.davidyang.coffeeshop.orderservice.model;

import lombok.Data;

@Data
public class Order {

  private Integer id;

  public Order(Integer id) {
    this.id = id;
  }
}
