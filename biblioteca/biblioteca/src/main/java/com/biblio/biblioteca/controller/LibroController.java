package com.biblio.biblioteca.controller;

import com.biblio.biblioteca.dto.LibroDTO;
import com.biblio.biblioteca.dto.LibroRequestDTO;
import com.biblio.biblioteca.model.Libro;
import com.biblio.biblioteca.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("libros")
public class LibroController {
    @Autowired
    private LibroService libroService;

    @GetMapping("")
    public List<LibroDTO> getAll(){
        return  libroService.getAll();
    }

    @GetMapping("/{id}")
    public Libro getById(@PathVariable Long id){
            return  libroService.getById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
          libroService.deleteById(id);
    }

    @PostMapping("")
    public void create(@RequestBody LibroRequestDTO libroRequestDTO){
        libroService.add(libroRequestDTO);
    }

}
