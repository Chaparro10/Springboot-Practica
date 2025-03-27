package com.market.platzi_market.persistence.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity()
@Table(name = "compras")
@Data()
public class compra {

    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer id_cliente;
    private Integer id_metogopago;
    private String comentario;
    private Integer estado;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Double subtotal;
    private Double total;

}
