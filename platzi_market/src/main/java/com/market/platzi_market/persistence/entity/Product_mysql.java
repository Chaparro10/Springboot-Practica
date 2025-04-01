package com.market.platzi_market.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity()
@Data()
@AllArgsConstructor()
@NoArgsConstructor()
@Table(name = "products")
public class Product_mysql {

    @Id()
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer id_categoria;
    @Column(name = "codeBar")
    private String codeBar;

    @Column(name = "precioVenta")
    private Double precioVenta;
    private Integer total_stock;
    private  Boolean estado;


    @ManyToOne
    @JoinColumn(name = "id_categoria", insertable = false, updatable = false)
    private Categoria categoria;
}



