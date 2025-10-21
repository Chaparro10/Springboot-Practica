package com.biblio.biblioteca.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Entity
@Data
@Table(name = "categorias")
public class Categoria {
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private  String descripcion;

    @OneToMany(mappedBy = "categoria")
    //@JsonIgnoreProperties("categoria")
    private List<Libro> libros;


}
