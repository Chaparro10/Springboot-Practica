package com.platzi.platzi_pizzeria.persistence.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "customer")
@Data
@ToString
@NoArgsConstructor
public class CustomerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String address;
    private String email;
    @Column(nullable = false,length = 20)
    private String phone_number;

    //Relacion uno a muchos con Order
    @OneToMany(mappedBy = "customersEntity")
    private List<OrderEntity> orderEntities;
}
