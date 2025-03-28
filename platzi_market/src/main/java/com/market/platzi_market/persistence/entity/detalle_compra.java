package com.market.platzi_market.persistence.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity()
@Table(name = "detalle_compra")
@Data()
@AllArgsConstructor()
@NoArgsConstructor()
public class detalle_compra {

    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

    private Integer id_compra;
    private Integer id_producto;
    private  Integer estado;
    private String comentario;
    private Double subtotal;
    private Double total;


    @ManyToOne
    @JoinColumn(name = "id_compra")
    private compra compras;

}
