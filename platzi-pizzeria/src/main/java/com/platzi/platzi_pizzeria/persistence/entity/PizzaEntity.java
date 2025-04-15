package com.platzi.platzi_pizzeria.persistence.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "pizza")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PizzaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "TINYINT")
    private Boolean available;

    private String description;

    @Column(nullable = false)
    private String name;

    @Column( scale = 2)
    private Double price;

    @Column(columnDefinition = "TINYINT")
    private Boolean vegan;

    @Column(columnDefinition = "TINYINT")
    private Boolean vegetarian;


    @Override
    public String toString() {
        return "PizzaEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", available=" + available +
                ", vegan=" + vegan +
                ", vegetarian=" + vegetarian +
                '}';
    }


}
