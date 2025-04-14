package com.platzi.platzi_pizzeria.web.controller;


import com.platzi.platzi_pizzeria.persistence.entity.OrderEntity;
import com.platzi.platzi_pizzeria.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;



    @GetMapping
    public List<OrderEntity> getAll(){
        return this.orderService.getAll();
    }



}
