package com.davidyang.coffeeshop.orderpersistence.listeners;

import com.davidyang.coffeeshop.orderpersistence.service.OrderService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class OrderListener {

    private final ObjectMapper objectMapper;
    private final OrderService orderService;

    public OrderListener(ObjectMapper objectMapper, OrderService orderService) {
        this.objectMapper = objectMapper;
        this.orderService = orderService;
    }

//    @KafkaListener(topics = "")
//    public String listens(final String in) {
//
//    }
}
