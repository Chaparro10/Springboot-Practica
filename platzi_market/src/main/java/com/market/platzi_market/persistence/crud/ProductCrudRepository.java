package com.market.platzi_market.persistence.crud;

import com.market.platzi_market.persistence.entity.Product_mysql;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductCrudRepository extends CrudRepository<Product_mysql,Long> {


    @Query(value = "SELECT * FROM products WHERE id_categoria=? ", nativeQuery = true)
    List<Product_mysql> getByCategoria(int categoriId);
}
