package com.platzi.platzi_pizzeria.service;

import com.platzi.platzi_pizzeria.persistence.entity.CustomerEntity;
import com.platzi.platzi_pizzeria.persistence.entity.PizzaEntity;
import com.platzi.platzi_pizzeria.persistence.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<CustomerEntity> getAll(){
        return this.customerRepository.findAll();
    }


    /*JPQL ->JAVA PERSISTENT QUERY LANGUAGE*/
    public CustomerEntity getByPhone(String phone){
        return this.customerRepository.findByphone(phone);
    }

}
