package com.biblio.biblioteca.controller;


import com.biblio.biblioteca.dto.LibroDTO;
import com.biblio.biblioteca.model.Autor;
import com.biblio.biblioteca.service.AutorService;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    public Autor getById(@PathVariable Long id){
        return  autorService.getById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
          autorService.delete(id);
    }

    @PostMapping("")
    public void save(@RequestBody Autor autor){
        autorService.create(autor);
    }



}
