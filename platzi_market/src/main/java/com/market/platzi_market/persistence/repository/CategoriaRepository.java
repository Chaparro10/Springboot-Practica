package com.market.platzi_market.persistence.repository;

import com.market.platzi_market.persistence.crud.CategoriaCrudRepository;
import com.market.platzi_market.persistence.entity.Categoria;
import com.market.platzi_market.persistence.entity.Product_mysql;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CategoriaRepository {


    @Autowired
    private CategoriaCrudRepository categoriaCrudRepository;

    public List<Categoria> getAll(){
        return (List<Categoria>)categoriaCrudRepository.findAll();
    }
}
