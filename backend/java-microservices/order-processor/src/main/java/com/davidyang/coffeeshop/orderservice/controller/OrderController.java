package com.davidyang.coffeeshop.orderservice.controller;

import com.davidyang.coffeeshop.orderservice.domain.Order;
import com.davidyang.coffeeshop.orderservice.service.OrderPublisherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author xipengyang
 */
@RequestMapping("/orders")
@RestController
@Slf4j
public class OrderController {

  final OrderPublisherService orderPublisherService;

  final AtomicLong count=new AtomicLong(0);

  public OrderController(OrderPublisherService orderPublisherService) {
    this.orderPublisherService = orderPublisherService;
  }

  @GetMapping(value="/health")
  public Boolean findOrder() {
    return true;
  }

  //  @GetMapping(value="/{orderId}")
//  public Optional<Order> findOrder(@PathVariable("orderId") int orderId) {
//    return Optional.of(new Order(orderId));
//  }

  @PostMapping(value = "/new")
  public void processOrder(){
    log.info("Post request to create orders");
    // Simulate
    final int orderSize = 4;

//    List newList = Collections.nCopies(orderSize);

    for(int i = 0; i < orderSize; i++){
      final UUID customerId = UUID.randomUUID();
      Order newOrder =  Order.builder().id(count.incrementAndGet()).name("customer" + "-" + customerId).description("test-product" + "-" + count).price( 10.0).build();
      orderPublisherService.publishRecord(newOrder, customerId);
    }
  }
}
