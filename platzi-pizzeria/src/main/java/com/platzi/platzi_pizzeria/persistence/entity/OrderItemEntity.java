package com.platzi.platzi_pizzeria.persistence.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "order_item")
public class OrderItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    private Integer id_order;

    private Integer id_pizza;

    @Column(nullable = false,columnDefinition = "Decimal(2,1)")
    private  Double quantity;
    @Column(nullable = false,columnDefinition = "Decimal(5,2)")
    private Double price;
}
