package com.platzi.platzi_pizzeria.web.controller;


import com.platzi.platzi_pizzeria.persistence.entity.OrderEntity;
import com.platzi.platzi_pizzeria.persistence.projection.OrderSummary;
import com.platzi.platzi_pizzeria.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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


    /*-----------QUERY METHOD--------------*/
    @GetMapping("/today")
    public List<OrderEntity> getAllToday(){
        return this.orderService.getTodayOrder();
    }

    @GetMapping("/todays")
    public List<OrderEntity> getAllMToday(){
        return this.orderService.getMTodayOrder();
    }

    @GetMapping("/outside")
    public List<OrderEntity> getAllOutside(){
        return this.orderService.getOrderOutside();
    }


    /*----------@Query SQL nativos---------------*/
    @GetMapping("customer")
    public List<OrderEntity> getAllOrderByCustomer(@RequestParam String id){
        return this.orderService.getOrderByCustomer(id);
    }
    @GetMapping("detail")
    public List<OrderSummary> getAllOrderDetail(@RequestParam String id){
        return this.orderService.findAllDetail(id);
    }




}
