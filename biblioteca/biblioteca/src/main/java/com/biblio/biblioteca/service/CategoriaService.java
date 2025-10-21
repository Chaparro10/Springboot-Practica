package com.biblio.biblioteca.service;

import com.biblio.biblioteca.model.Categoria;
import com.biblio.biblioteca.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CategoriaService {

    @Autowired
    private  CategoriaRepository categoriaRepository;



    // Inyección por constructor
   // public CategoriaService(CategoriaRepository categoriaRepository) {
     //   this.categoriaRepository = categoriaRepository;
    //}

    public List<Categoria> getAll(){
        return categoriaRepository.findAll();
    }

    public Categoria getCategoriaByID(Long id){
            return  categoriaRepository.findById(id).orElse(null);
    }

    public void deleteByID(Long id){
        categoriaRepository.deleteById(id);
    }
    public Categoria create(Categoria categoria){
            return categoriaRepository.save(categoria);
    }

}
