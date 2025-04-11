package com.platzi.platzi_pizzeria.persistence.repository;

import com.platzi.platzi_pizzeria.persistence.entity.PizzaEntity;
import org.springframework.data.repository.ListCrudRepository;

public interface PizzaRepository  extends ListCrudRepository<PizzaEntity,Integer> {
}
