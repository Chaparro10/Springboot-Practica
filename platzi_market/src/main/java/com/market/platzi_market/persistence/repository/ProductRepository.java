package com.market.platzi_market.persistence.repository;

import com.market.platzi_market.persistence.crud.ProductCrudRepository;
import com.market.platzi_market.persistence.entity.Product_mysql;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;



@Repository
public class ProductRepository {
    @Autowired
    private ProductCrudRepository productCrudRepository;

    //obtener todos los productos
    public List<Product_mysql> getAllProduct() {
        return (List<Product_mysql>) productCrudRepository.findAll();
    }

    public List<Product_mysql> getProductsByCategory(int id){
        return productCrudRepository.getByCategoria(id);
    }

    public Product_mysql  save (Product_mysql product_mysql){
            return productCrudRepository.save(product_mysql);
    }

    public void delete(Long idProducto){
        productCrudRepository.deleteById(idProducto);
    }
}
