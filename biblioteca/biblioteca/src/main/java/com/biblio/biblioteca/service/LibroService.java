package com.biblio.biblioteca.service;


import com.biblio.biblioteca.model.Libro;
import com.biblio.biblioteca.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibroService {
    @Autowired
    private LibroRepository libroRepository;


    public List<Libro> getAll(){
        return libroRepository.findAll();
    }

    public Libro getById(Long id){
        return  libroRepository.findById(id).orElse(null);
    }

    public void add(Libro libro){
         libroRepository.save(libro);
        System.out.println("Libro agregado correctamente");
    }

    public  void deleteById(Long id){
        libroRepository.deleteById(id);
        System.out.println("Libro eliminado correctamente");
    }
}
