package com.platzi.platzi_pizzeria.persistence.repository;

import com.platzi.platzi_pizzeria.persistence.entity.CustomerEntity;
import org.springframework.data.repository.ListCrudRepository;

public interface CustomerRepository  extends ListCrudRepository<CustomerEntity,Integer> {
}
