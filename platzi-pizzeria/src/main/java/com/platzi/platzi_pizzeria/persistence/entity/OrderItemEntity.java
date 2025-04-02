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


    //Relacion Muchos a uno con OrderEntity
    @ManyToOne
    @JoinColumn(name = "id_order",insertable = false,updatable = false)
    private  OrderEntity orderEntity;


    //Relacion One to One con PizzaEntity
    @OneToOne
    @JoinColumn(name = "id_pizza" , referencedColumnName = "id",insertable = false,updatable = false)
    private PizzaEntity pizzaEntity;

}
