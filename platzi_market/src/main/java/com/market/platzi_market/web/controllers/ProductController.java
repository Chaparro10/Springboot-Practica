package com.market.platzi_market.web.controllers;


import com.market.platzi_market.domain.service.ProductService;
import com.market.platzi_market.persistence.entity.Product_mysql;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;


    @GetMapping("")
    private List<Product_mysql> getAll(){
        return productService.getAll();
    }

    //por params
    @GetMapping("/{id_categoria}")
    private List<Product_mysql> getByCatgoriaId(@PathVariable("id_categoria") int id_categoria){
        return productService.getProductsByCategory(id_categoria);
    }

    //por query
    /// categoria?id_categoria=1
    @GetMapping("/categoria")
    private List<Product_mysql> getByCatgoria(@RequestParam int id_categoria, @RequestParam(required = false) String name){
        return productService.getProductsByCategory(id_categoria);
    }

    @PostMapping("")
    private Product_mysql save (@RequestBody Product_mysql product_mysql){
            return productService.save(product_mysql);
    }

    @DeleteMapping("/delete/{id}")
    private void delete(@PathVariable Long  id){
        productService.delete(id);
    }
}
