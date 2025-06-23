package com.microservices.products.service;


import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.KafkaListeners;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {


  @KafkaListener(topics = "mi-topic",groupId = "microservice-b-group")
    public void listen(String message){
        System.out.println("Mensaje recibido en microservicio producto "+ message);
    }
}
