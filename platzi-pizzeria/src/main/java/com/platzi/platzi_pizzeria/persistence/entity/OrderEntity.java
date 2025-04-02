package com.platzi.platzi_pizzeria.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "pizza_order")
@Getter
@Setter
@NoArgsConstructor
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
}
