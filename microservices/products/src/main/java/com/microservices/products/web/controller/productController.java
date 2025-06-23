

package com.microservices.products.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/service-products")
public class productController {

    @GetMapping("/hello")
    public String product(){
        return "Hola desde servicio de products";
    }
}