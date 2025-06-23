


package com.microservices.orders.web.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ordersController {

    @GetMapping("/api/service-orders/hello")
    public String order(){
        return "Hola desde servicio de orders";
    }
}