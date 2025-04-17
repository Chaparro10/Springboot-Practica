package com.platzi.platzi_pizzeria.persistence.repository;

import com.platzi.platzi_pizzeria.persistence.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

public interface CustomerRepository  extends JpaRepository<CustomerEntity,Integer> {



    /*JPQL ->JAVA PERSISTENT QUERY LANGUAGE*/
    @Query(value = "SELECT c FROM CustomerEntity c where c.phone_number= :phone ")
    CustomerEntity findByphone(@Param("phone") String phone);
}
