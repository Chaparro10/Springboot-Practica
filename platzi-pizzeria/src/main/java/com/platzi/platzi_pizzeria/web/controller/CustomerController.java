package com.platzi.platzi_pizzeria.web.controller;


import com.platzi.platzi_pizzeria.persistence.entity.CustomerEntity;
import com.platzi.platzi_pizzeria.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("phone/{phone}")
    public CustomerEntity getByPhone(@PathVariable String phone){
        return this.customerService.getByPhone(phone);
    }

}
