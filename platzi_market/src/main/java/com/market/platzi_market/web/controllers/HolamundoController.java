package com.market.platzi_market.web.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



//endpoint--> localhost:8080/platzi-market/api/holamundo/hola
@RestController
@RequestMapping("/holamundo")
public class HolamundoController {

    @GetMapping("/hola")
    public String HolaMundo(){
        return "Hola Mundo desde el controlado";
    }
}
