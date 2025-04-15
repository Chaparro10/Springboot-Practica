package com.platzi.platzi_pizzeria.service;


import com.platzi.platzi_pizzeria.persistence.entity.PizzaEntity;
import com.platzi.platzi_pizzeria.persistence.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PizzaService {

    //private  final JdbcTemplate jdbcTemplate;

    @Autowired
    private  PizzaRepository pizzaRepository;


  //  @Autowired
//    public PizzaService(JdbcTemplate jdbcTemplate, PizzaRepository pizzaRepository) {
//        this.jdbcTemplate = jdbcTemplate;
//        this.pizzaRepository=pizzaRepository;
//    }


    public List<PizzaEntity> getAllPizza(){
        return this.pizzaRepository.findAll();
    }

    public PizzaEntity getPizzaById(int idpizza){
            return this.pizzaRepository.findById(idpizza).orElse(null);
    }

    public PizzaEntity savePizza(PizzaEntity pizza){
        return this.pizzaRepository.save(pizza);
    }


    public Boolean ExistPizza(int idPizza){
            return this.pizzaRepository.existsById(idPizza);
    }
    public void deletePizza(int id_pizza){
         this.pizzaRepository.deleteById(id_pizza);
    }
//    public List<PizzaEntity> getAll(){
//        String sql = "SELECT id, available, description, name, price, vegan, vegetarian FROM pizza";
//        List<PizzaEntity> lista = this.jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(PizzaEntity.class));
//        return lista;
//    }




    /*----------------------QUERY METHOD----------------------*/

    public List<PizzaEntity> getAllByAvailable(){
        return  this.pizzaRepository.findAllByAvailableTrueOrderByPrice();
    }

    public List<PizzaEntity> getAllByAvailableAndName(String name){
        return this.pizzaRepository.findAllByAvailableTrueAndNameIgnoreCase(name);
    }

    public  List<PizzaEntity> getAllByAvailableContainingDescription(String description){
        return this.pizzaRepository.findAllByAvailableTrueAndDescriptionContainingIgnoreCase(description);
    }

    public List<PizzaEntity> getAllByAvailableNotContainingDescription(String description){
        return this.pizzaRepository.findAllByAvailableTrueAndDescriptionNotContainingIgnoreCase(description);
    }

    public PizzaEntity getPizzaByName(String name){
        return this.pizzaRepository.findFirstByAvailableTrueAndNameIgnoreCase(name);
    }

    public  List<PizzaEntity> getTop3Pizza(double price){
        return this.pizzaRepository.findTop3ByAvailableTrueAndPriceLessThanEqualOrderByPriceDesc(price);
    }
    public List<PizzaEntity> getTop3PizzaMayor(double price){
            return this.pizzaRepository.findTop3ByPriceGreaterThanEqualOrderByPriceDesc(price);
    }
}
