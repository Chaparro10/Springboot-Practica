package com.biblio.biblioteca.controller;


import com.biblio.biblioteca.model.Prestamo;
import com.biblio.biblioteca.service.PrestamoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("prestamos")
public class PrestamoController {

    @Autowired
    private PrestamoService prestamoService;


    public List<Prestamo> getAll(){
        return  prestamoService.getAll();
    }

    @GetMapping("/{id_usuario}")
    public List<Prestamo> getById(Long id_usuario){
            return  prestamoService.getAllByUser(id_usuario);
    }

    @PostMapping("")
    public  void save(Prestamo prestamo){
        prestamoService.create(prestamo);
    }
}
