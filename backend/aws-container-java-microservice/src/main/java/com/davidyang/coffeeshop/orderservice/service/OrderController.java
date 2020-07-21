package com.davidyang.coffeeshop.orderservice.service;

import com.davidyang.coffeeshop.orderservice.model.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * @author xipengyang
 */
@RequestMapping("/orders")
@RestController
@Slf4j
public class OrderController {

  @GetMapping(value="/{orderId}")
  public Optional<Order> findOrder(@PathVariable("orderId") int orderId) {
    return Optional.of(new Order(orderId));
  }
}
