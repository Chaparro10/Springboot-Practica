package com.market.platzi_market.domain.service;

import com.market.platzi_market.persistence.entity.Categoria;
import com.market.platzi_market.persistence.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<Categoria> getAll(){
        return categoriaRepository.getAll();
    }
}
