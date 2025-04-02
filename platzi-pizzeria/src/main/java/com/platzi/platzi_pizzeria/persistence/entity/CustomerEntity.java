package com.platzi.platzi_pizzeria.persistence.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "customer")
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String address;
    private String email;
    @Column(nullable = false,length = 20)
    private String phone_number;
}
