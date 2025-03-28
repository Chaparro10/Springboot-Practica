package com.market.platzi_market.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity()
@Data()
@AllArgsConstructor()
@NoArgsConstructor()
@Table(name = "product")
public class product_mysql {

    @Id()
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer id_categoria;
    private String codeBar;
    private Double precioVenta;
    private Integer total_stock;
    private  Boolean estado;

}



