package com.biblio.biblioteca.controller;

import com.biblio.biblioteca.dto.LibroDTO;
import com.biblio.biblioteca.model.Libro;
import com.biblio.biblioteca.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
