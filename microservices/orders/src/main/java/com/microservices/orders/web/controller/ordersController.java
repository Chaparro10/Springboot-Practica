


package com.microservices.orders.web.controller;


import com.microservices.orders.services.KafkaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/service-orders/")
public class ordersController {

    @Autowired
    private KafkaService kafkaServiceproducer;

    @PostMapping("send")
    public ResponseEntity<String> send(@RequestBody String message){
            kafkaServiceproducer.sendMessage(message);
            return  ResponseEntity.ok("Mensaje enviado "+ message);
    }

    @GetMapping("hello")
    public String order(){
        return "Hola desde servicio de orders";
    }
}