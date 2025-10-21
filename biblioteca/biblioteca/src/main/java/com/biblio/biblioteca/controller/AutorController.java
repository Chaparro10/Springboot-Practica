package com.biblio.biblioteca.controller;


import com.biblio.biblioteca.model.Autor;
import com.biblio.biblioteca.service.AutorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("autores")
public class AutorController {

    private final AutorService autorService;

    public AutorController(AutorService autorService){
        this.autorService=autorService;
    }


    @GetMapping("")
    public List<Autor> getAll(){
        return  autorService.getAll();
    }

}
