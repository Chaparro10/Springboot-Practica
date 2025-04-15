package com.platzi.platzi_pizzeria.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "pizza_order")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class OrderEntity {


        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;
        @Column(nullable = false)
        private Integer id_customer;

        @Column(nullable = false,columnDefinition = "DATETIME")
    private LocalDateTime date;

        @Column(nullable = false,columnDefinition = "DECIMAL(6,2)")
    private Double total;

        @Column(nullable = false,columnDefinition = "CHAR(1)")
    private String method;
    private String additional_notes;


    //Relacion Muchos a Uno con customer
    @ManyToOne
    @JoinColumn(name = "id_customer", insertable = false,updatable = false)
    private CustomerEntity customersEntity;


    @OneToMany(mappedBy = "orderEntity")
    private List<OrderItemEntity> orderItemEntities;
}
