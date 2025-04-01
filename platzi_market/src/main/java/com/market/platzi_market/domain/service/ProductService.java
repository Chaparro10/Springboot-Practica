package com.market.platzi_market.domain.service;


import com.market.platzi_market.persistence.entity.Product_mysql;
import com.market.platzi_market.persistence.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;


    public List<Product_mysql> getAll(){
        System.out.println("Servicio"+productRepository.getAllProduct());
        return  productRepository.getAllProduct();
    }

    public List<Product_mysql> getProductsByCategory(int idCategoria){
        return productRepository.getProductsByCategory(idCategoria);
    }

    public Product_mysql save(Product_mysql product_mysql){
        return productRepository.save(product_mysql);
    }

    public void delete(Long idProducto){
        productRepository.delete(idProducto);
    }

    public  boolean ExistCategoria(Long id){
        return productRepository.ExistProduct(id);
    }
}
