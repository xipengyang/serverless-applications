package com.davidyang.coffeeshop.orderpersistence.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ObjectMapperConfig {

    @Bean
    public ObjectMapper objectMapper(){

        final ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper;

    }
}
