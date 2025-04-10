package com.platzi.platzi_pizzeria.service;


import com.platzi.platzi_pizzeria.persistence.entity.PizzaEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PizzaService {

    private  final JdbcTemplate jdbcTemplate;

    @Autowired
    public PizzaService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<PizzaEntity> getAll(){
        String sql = "SELECT id, available, description, name, price, vegan, vegetarian FROM pizza";
        List<PizzaEntity> lista = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(PizzaEntity.class));
        return lista;
    }
}
