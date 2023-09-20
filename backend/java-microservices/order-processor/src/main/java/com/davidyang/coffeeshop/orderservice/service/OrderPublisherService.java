package com.davidyang.coffeeshop.orderservice.service;

import com.davidyang.coffeeshop.orderservice.config.KafkaConfigProps;
import com.davidyang.coffeeshop.orderservice.domain.Order;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Slf4j
@Service
public class OrderPublisherService {

    private final ObjectMapper objectMapper;

    private final KafkaTemplate<String, String> kafkaTemplate;

    private final KafkaConfigProps kafkaConfigProps;

    public OrderPublisherService(ObjectMapper objectMapper, KafkaTemplate<String, String> kafkaTemplate, KafkaConfigProps kafkaConfigProps) {
        this.objectMapper = objectMapper;
        this.kafkaTemplate = kafkaTemplate;
        this.kafkaConfigProps = kafkaConfigProps;
    }

    public void publishRecord(final Order order, final UUID customerId) {
        log.info("publish order {} to topic {}", order, kafkaConfigProps.getTopic());
        try {
            final String payload = objectMapper.writeValueAsString(order);
            CompletableFuture<SendResult<String, String>> result = kafkaTemplate.send(kafkaConfigProps.getTopic(), customerId.toString(), payload);
            log.info("result {}" , result.get());
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
