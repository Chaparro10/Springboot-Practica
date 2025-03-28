package com.market.platzi_market.persistence.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

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

    @ManyToOne
    @JoinColumn(name = "id_cliente", insertable = false,updatable = false)
    private clientes clientes;

    @OneToMany(mappedBy = "compras")
    private List<detalle_compra> detalleCompras;

}
