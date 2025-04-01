package com.market.platzi_market.web.controllers;


import com.market.platzi_market.domain.service.ProductService;
import com.market.platzi_market.persistence.entity.Product_mysql;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;


    @GetMapping("")
    private ResponseEntity<List<Product_mysql>> getAll(){
        return new ResponseEntity<>(productService.getAll(), HttpStatus.OK);
    }

    //por params
    @GetMapping("/{id_categoria}")
    private ResponseEntity <List<Product_mysql>> getByCatgoriaId(@PathVariable("id_categoria") int id_categoria){
        return new ResponseEntity<>(productService.getProductsByCategory(id_categoria),HttpStatus.OK);
    }

    //por query
    /// categoria?id_categoria=1
    @GetMapping("/categoria")
    private ResponseEntity<List<Product_mysql>> getByCatgoria(@RequestParam int id_categoria, @RequestParam(required = false) String name){
        return new ResponseEntity<>(productService.getProductsByCategory(id_categoria),HttpStatus.OK);
    }

    @PostMapping("")
    private ResponseEntity<Product_mysql> save (@RequestBody Product_mysql product_mysql){
            return  new ResponseEntity<>(productService.save(product_mysql),HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    private void  delete(@PathVariable Long  id){
        productService.delete(id);
    }
}
