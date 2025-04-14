package com.platzi.platzi_pizzeria.persistence.repository;

import com.platzi.platzi_pizzeria.persistence.entity.OrderEntity;
import org.springframework.data.repository.ListCrudRepository;

public interface OrderRepository extends ListCrudRepository<OrderEntity, Integer> {
}
