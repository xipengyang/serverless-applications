package com.davidyang.coffeeshop.orderpersistence.listeners;

import com.davidyang.coffeeshop.orderpersistence.entity.Order;
import com.davidyang.coffeeshop.orderpersistence.exception.InvalidMessageException;
import com.davidyang.coffeeshop.orderpersistence.service.OrderService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@Slf4j
public class OrderListener {

    private final ObjectMapper objectMapper;
    private final OrderService orderService;

    public OrderListener(ObjectMapper objectMapper, OrderService orderService) {
        this.objectMapper = objectMapper;
        this.orderService = orderService;
    }

    @KafkaListener(topics = "orders.processed")
    public void processOrderRecord(final String rec) {
        log.info("Received record {}", rec);

        final Map<String, Object> payload = readJsonAsMap(rec);

        final Order order = readFromPayload(payload);

        orderService.saveOrder(order);

        log.info("Order persisted");
    }

    private Order readFromPayload(Map<String, Object> payload) {
        return Order.builder()
                .id(Long.parseLong(payload.get("id").toString()))
                .description(payload.get("description").toString())
                .name(payload.get("name").toString())
                .price(Double.parseDouble(payload.get("price").toString())).build();
    }

    private Map<String,Object> readJsonAsMap(String json) {
        try{
            final TypeReference<HashMap<String,Object>> typeRef = new TypeReference<>() {};
            return objectMapper.readValue(json, typeRef);
        } catch(JsonProcessingException ex) {
            throw new InvalidMessageException();
        }
    }
}
