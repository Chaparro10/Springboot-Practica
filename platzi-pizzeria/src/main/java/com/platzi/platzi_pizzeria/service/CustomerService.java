package com.platzi.platzi_pizzeria.service;

import com.platzi.platzi_pizzeria.persistence.entity.CustomerEntity;
import com.platzi.platzi_pizzeria.persistence.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CustomerService {



    @Autowired
    private CustomerRepository customerRepository;


    public List<CustomerEntity> getAll(){
        return this.customerRepository.findAll();
    }
}
