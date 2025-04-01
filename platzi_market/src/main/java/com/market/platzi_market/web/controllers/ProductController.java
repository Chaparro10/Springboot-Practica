package com.market.platzi_market.web.controllers;


import com.market.platzi_market.domain.service.ProductService;
import com.market.platzi_market.persistence.entity.Product_mysql;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController()
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;


    @GetMapping("")
    private ResponseEntity<List<Product_mysql>> getAll(){
         List<Product_mysql> datos = productService.getAll();
        return !datos.isEmpty()
                ? ResponseEntity.ok(datos)
                : ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    //por params
    @GetMapping("/{id_categoria}")
    private ResponseEntity <List<Product_mysql>> getByCatgoriaId(@PathVariable("id_categoria") int id_categoria){
        List<Product_mysql> datos = productService.getProductsByCategory(id_categoria);
        return !datos.isEmpty() ? ResponseEntity.ok(datos) : ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    //por query
    /// categoria?id_categoria=1
    @GetMapping("/categoria")
    private ResponseEntity<List<Product_mysql>> getByCatgoria(@RequestParam int id_categoria, @RequestParam(required = false) String name){
        return new ResponseEntity<>(productService.getProductsByCategory(id_categoria),HttpStatus.OK);
    }

    @PostMapping("")
    private ResponseEntity<Product_mysql> save (@RequestBody Product_mysql product_mysql){
            return new ResponseEntity<>(productService.save(product_mysql),HttpStatus.CREATED);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Map<String, Object>> delete(@PathVariable Long id) {
        boolean exist = productService.ExistCategoria(id);
        if (exist) {
            productService.delete(id);
            Map<String, Object> response = new HashMap<>();
            response.put("ok", true);
            response.put("msg", "Producto eliminado correctamente");
            return ResponseEntity.ok(response);
        } else {
            Map<String, Object> response = new HashMap<>();
            response.put("ok", false);
            response.put("msg", "No existe el producto a eliminar");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

}
