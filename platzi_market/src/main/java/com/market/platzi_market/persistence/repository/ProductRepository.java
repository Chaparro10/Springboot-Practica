package com.market.platzi_market.persistence.repository;

import com.market.platzi_market.persistence.crud.ProductCrudRepository;
import com.market.platzi_market.persistence.entity.Product_mysql;

import java.util.List;


public class ProductRepository {
    private ProductCrudRepository productCrudRepository;

    //obtener todos los productos
    public List<Product_mysql> getAllProduct() {
        return (List<Product_mysql>) productCrudRepository.findAll();
    }

    public List<Product_mysql> getProductsByCategory(int id){
        return productCrudRepository.getByCategoria(id);
    }
}
