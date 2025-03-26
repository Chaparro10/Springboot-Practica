package com.market.platzi_market.persistence.entity;


import jakarta.persistence.*;

@Entity()
@Table(name = "products")
public class product {

    @Id()
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column()
    private Long id;


    private String name;


    private Integer id_categoria;

    private String codeBar;

    private Double precioVenta;

    private Integer total_stock;

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }

    public Integer getId_categoria() {
        return id_categoria;
    }

    public String getCodeBar() {
        return codeBar;
    }

    public Double getPrecioVenta() {
        return precioVenta;
    }

    public Integer getTotal_stock() {
        return total_stock;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId_categoria(Integer id_categoria) {
        this.id_categoria = id_categoria;
    }

    public void setCodeBar(String codeBar) {
        this.codeBar = codeBar;
    }

    public void setTotal_stock(Integer total_stock) {
        this.total_stock = total_stock;
    }

    public void setPrecioVenta(Double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    private  Boolean estado;

}
