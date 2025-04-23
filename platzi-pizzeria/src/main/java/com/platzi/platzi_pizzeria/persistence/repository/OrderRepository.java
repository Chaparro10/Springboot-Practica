package com.platzi.platzi_pizzeria.persistence.repository;

import com.platzi.platzi_pizzeria.persistence.entity.OrderEntity;
import com.platzi.platzi_pizzeria.persistence.projection.OrderSummary;
import org.springframework.core.annotation.Order;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface OrderRepository extends ListCrudRepository<OrderEntity, Integer> {
    /*--------QUERY METHOD---------*/
    //Hibernate: select oe1_0.id,oe1_0.additional_notes,oe1_0.id_customer,oe1_0.date,oe1_0.method,oe1_0.total from pizza_order oe1_0 where oe1_0.date>?
    List<OrderEntity> findAllByDateAfter(LocalDateTime date);
    List<OrderEntity> findAllByDateBefore(LocalDateTime date);

    List<OrderEntity> findAllByMethodIn(List<String> methods);



    /*------------- @QUERY sql nativos--------------*/
    @Query(value = "SELECT * FROM pizza_order WHERE id_customer= :id",nativeQuery = true)
    List<OrderEntity> findCustomerOrder(@Param("id") String idCustomer);


    @Query(value = """
            SELECT
            po.id as id_order,
            cu.name as customer,
            po.date as order_date,
            pi.price,
            pi.name
            FROM pizza_order as po
            INNER JOIN customer as cu ON po.id_customer=cu.id
            INNER JOIN order_item as io ON po.id=io.id_order
            INNER JOIN pizza as pi ON io.id_pizza=pi.id
            WHERE po.id =:id
            GROUP BY po.id,cu.name,po.date,pi.price,pi.`name`
            """, nativeQuery = true)
    List<OrderSummary> findAllDetail(@Param("id") String idOrder);


    @Procedure(value = "TakeRandomPizzaOrder",outputParameterName = "orderTaken")
    boolean saveRandomOrder(@Param("customer_id") String idCustomer,@Param("method") String method);

    @Procedure(value = "getOrderById")
    OrderEntity getOrderById(@Param("id") Integer id);
}
