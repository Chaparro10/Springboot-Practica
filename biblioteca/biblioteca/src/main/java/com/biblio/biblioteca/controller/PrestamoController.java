package com.biblio.biblioteca.controller;


import com.biblio.biblioteca.model.Prestamo;
import com.biblio.biblioteca.service.PrestamoService;
import org.springframework.beans.factory.annotation.Autowired;
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
}
