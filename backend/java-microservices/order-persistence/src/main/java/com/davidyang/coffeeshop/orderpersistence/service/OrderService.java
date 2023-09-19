package com.davidyang.coffeeshop.orderpersistence.service;

import com.davidyang.coffeeshop.orderpersistence.entity.Order;
import com.davidyang.coffeeshop.orderpersistence.repository.OrderRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void saveOrder(Order order) {
        orderRepository.save(order);
    }

    public Page<Order> listOrders(Pageable pageable) {
        return orderRepository.findAll(pageable);
    }
}
