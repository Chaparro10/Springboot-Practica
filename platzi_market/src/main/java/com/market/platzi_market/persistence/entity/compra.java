package com.market.platzi_market.persistence.entity;


import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity()
@Table(name = "compras")
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


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Integer getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(Integer id_cliente) {
        this.id_cliente = id_cliente;
    }

    public Integer getId_metogopago() {
        return id_metogopago;
    }

    public void setId_metogopago(Integer id_metogopago) {
        this.id_metogopago = id_metogopago;
    }
}
