package com.microservices.orders.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaService {

    @Autowired
    private KafkaTemplate<String ,String> kafkaTemplate;

    private final String topic="mi-topic";

    public void sendMessage(String message) {
            kafkaTemplate.send(topic,message);
    }


}
