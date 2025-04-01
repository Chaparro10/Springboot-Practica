package com.market.platzi_market.persistence.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;


// Marca la clase como un documento de MongoDB
@Document(collection = "products")
@Data()
@AllArgsConstructor()
@NoArgsConstructor()
public class Product {

    @Id()
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer id_categoria;
    private String codeBar;
    private Double precioVenta;
    private Integer total_stock;
    private  Boolean estado;


    @ManyToOne
    @JoinColumn(name = "id_categoria", insertable = false, updatable = false)
    private Categoria categoria;


}
