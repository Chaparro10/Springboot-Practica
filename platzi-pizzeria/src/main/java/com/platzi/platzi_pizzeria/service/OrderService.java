package com.platzi.platzi_pizzeria.service;

import com.platzi.platzi_pizzeria.persistence.entity.OrderEntity;
import com.platzi.platzi_pizzeria.persistence.projection.OrderSummary;
import com.platzi.platzi_pizzeria.persistence.repository.OrderRepository;
import com.platzi.platzi_pizzeria.service.dto.RandomOrderDTO;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Service
public class OrderService {
//    public static  void main(String []args){
//        OrderEntity o = new OrderEntity();
//        o.
//    }

    @Autowired
    private OrderRepository orderRepository;


    public List<OrderEntity> getAll(){
        return  this.orderRepository.findAll();
    }




    /*---------QUERY METHOD------------*/

    private static  final String DELIVERY="D";
    private static  final  String CARRYOUT="C";
    public List<OrderEntity> getTodayOrder(){
        LocalDateTime today = LocalDate.now().atTime(0,0);
        return  this.orderRepository.findAllByDateAfter(today);
    }
    public List<OrderEntity> getMTodayOrder(){
        LocalDateTime today = LocalDate.now().atTime(0,0);
        return  this.orderRepository.findAllByDateBefore(today);
    }

    public List<OrderEntity> getOrderOutside(){
            List<String> me = Arrays.asList(DELIVERY,CARRYOUT);

           return this.orderRepository.findAllByMethodIn(me);
    }



    /*-------------@Query sql nativos------------*/

    @Secured("ROLE_ADMIN")
    public  List<OrderEntity> getOrderByCustomer(String id){
        return this.orderRepository.findCustomerOrder(id);
    }

    public List<OrderSummary> findAllDetail(String id){
        return this.orderRepository.findAllDetail(id);
    }


    @Transactional
    public boolean saveRandomOrder(RandomOrderDTO randomOrderDTO){
        System.out.println(randomOrderDTO);
        return this.orderRepository.saveRandomOrder(randomOrderDTO.getIdCustomer(),randomOrderDTO.getMethod());
    }

    @Transactional
    public OrderEntity getOrderById(Integer id){
            return this.orderRepository.getOrderById(id);
    }
}
