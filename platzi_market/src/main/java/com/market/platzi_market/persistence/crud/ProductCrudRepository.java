package com.market.platzi_market.persistence.crud;

import com.market.platzi_market.persistence.entity.Product_mysql;
import org.springframework.data.repository.CrudRepository;

public interface ProductCrudRepository extends CrudRepository<Product_mysql,Long> {
}
