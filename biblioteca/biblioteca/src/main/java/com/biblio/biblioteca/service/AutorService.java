package com.biblio.biblioteca.service;

import com.biblio.biblioteca.model.Autor;
import com.biblio.biblioteca.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutorService {

    @Autowired
    private AutorRepository autorRepository;

    public List<Autor> getAll(){
        return  autorRepository.findAll();
    }

    public Autor getById(Long id){
        return autorRepository.findById(id).orElse(null);
    }
    public void delete(Long id){
        autorRepository.deleteById(id);
    }

    public void create(Autor autor ){
        autorRepository.save(autor);
    }


}
