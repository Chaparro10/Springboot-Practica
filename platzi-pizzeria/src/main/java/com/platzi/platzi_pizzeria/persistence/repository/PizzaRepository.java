package com.platzi.platzi_pizzeria.persistence.repository;

import com.platzi.platzi_pizzeria.persistence.entity.PizzaEntity;
import com.platzi.platzi_pizzeria.service.dto.UpdatePizzaPriceDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PizzaRepository  extends JpaRepository<PizzaEntity,Integer> {


    /*-------------------QUERY METHOD-------------------------*/

    //Hibernate: select pe1_0.id,pe1_0.available,pe1_0.description,pe1_0.name,pe1_0.price,pe1_0.vegan,pe1_0.vegetarian from pizza pe1_0 where pe1_0.available order by pe1_0.price
    List<PizzaEntity> findAllByAvailableTrueOrderByPrice();

    //Hibernate: select pe1_0.id,pe1_0.available,pe1_0.description,pe1_0.name,pe1_0.price,pe1_0.vegan,pe1_0.vegetarian from pizza pe1_0 where pe1_0.available and upper(pe1_0.name)=upper(?)
    List<PizzaEntity> findAllByAvailableTrueAndNameIgnoreCase(String name);

    //Hibernate: select pe1_0.id,pe1_0.available,pe1_0.description,pe1_0.name,pe1_0.price,pe1_0.vegan,pe1_0.vegetarian from pizza pe1_0 where pe1_0.available and upper(pe1_0.description) like upper(?) escape '\\'
    List<PizzaEntity> findAllByAvailableTrueAndDescriptionContainingIgnoreCase(String description);

    //Hibernate: select pe1_0.id,pe1_0.available,pe1_0.description,pe1_0.name,pe1_0.price,pe1_0.vegan,pe1_0.vegetarian from pizza pe1_0 where pe1_0.available and upper(pe1_0.description) not like upper(?) escape '\\'
    List<PizzaEntity> findAllByAvailableTrueAndDescriptionNotContainingIgnoreCase(String description);

    //Hibernate: select pe1_0.id,pe1_0.available,pe1_0.description,pe1_0.name,pe1_0.price,pe1_0.vegan,pe1_0.vegetarian from pizza pe1_0 where pe1_0.available and upper(pe1_0.name)=upper(?) limit ?
    PizzaEntity findFirstByAvailableTrueAndNameIgnoreCase(String nombre);

    //Hibernate: select pe1_0.id,pe1_0.available,pe1_0.description,pe1_0.name,pe1_0.price,pe1_0.vegan,pe1_0.vegetarian from pizza pe1_0 where pe1_0.available and pe1_0.price<=? order by pe1_0.price desc limit ?
    List<PizzaEntity> findTop3ByAvailableTrueAndPriceLessThanEqualOrderByPriceDesc(double price);

    //Hibernate: select pe1_0.id,pe1_0.available,pe1_0.description,pe1_0.name,pe1_0.price,pe1_0.vegan,pe1_0.vegetarian from pizza pe1_0 where pe1_0.price>=? order by pe1_0.price desc limit ?
    List<PizzaEntity> findTop3ByPriceGreaterThanEqualOrderByPriceDesc(double price);


    /*-------------@Query sql nativos------------*/

    @Query(value = """
            UPDATE pizza SET price =:#{#newPizaPrice.newPrice} where id=:#{#newPizaPrice.idPizza}
            """,nativeQuery = true)
    void updatePrice(@Param("newPizaPrice")UpdatePizzaPriceDto newPizaPrice);

}
