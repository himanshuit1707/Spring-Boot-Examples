package com.example.jms.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;

@Configuration
public class JmsJsonConfig {

    @Bean
    public MessageConverter converter() {
        MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
        converter.setTargetType(org.springframework.jms.support.converter.MessageType.TEXT);
        converter.setTypeIdPropertyName("_type");
        return converter;
    }
}