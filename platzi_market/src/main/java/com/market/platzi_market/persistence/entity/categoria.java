package com.market.platzi_market.persistence.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity()
@Data()
@Table(name = "categorias")
public class categoria {


    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer estado;

     @OneToMany(mappedBy = "categoria")
    private List<product>productos;
}
