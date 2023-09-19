package com.davidyang.coffeeshop.orderpersistence.controller;

import com.davidyang.coffeeshop.orderpersistence.entity.Order;
import com.davidyang.coffeeshop.orderpersistence.service.OrderService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@RestController
public class OrderController {


    private OrderService orderService;


    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @RequestMapping("/orders")
    public Page<Order> getOrders(final Pageable pageable) {
        return orderService.listOrders(pageable);
    }
}
