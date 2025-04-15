package com.platzi.platzi_pizzeria.persistence.repository;

import com.platzi.platzi_pizzeria.persistence.entity.OrderEntity;
import org.springframework.data.repository.ListCrudRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface OrderRepository extends ListCrudRepository<OrderEntity, Integer> {
    /*--------QUERY METHOD---------*/
    //Hibernate: select oe1_0.id,oe1_0.additional_notes,oe1_0.id_customer,oe1_0.date,oe1_0.method,oe1_0.total from pizza_order oe1_0 where oe1_0.date>?
    List<OrderEntity> findAllByDateAfter(LocalDateTime date);
    List<OrderEntity> findAllByDateBefore(LocalDateTime date);

    List<OrderEntity> findAllByMethodIn(List<String> methods);
}
