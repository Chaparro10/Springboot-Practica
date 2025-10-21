package com.biblio.biblioteca.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@Table(name = "libros")
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String isbn;
    private int anioPublicacion;
    private int ejemplaresDisponibles;

    // Relación con autor
    @ManyToOne
    @JoinColumn(name = "autor_id")
    @JsonIgnoreProperties("libros") // Evita bucles Autor -> Libro -> Autor
    private Autor autor;

    // Relación con categoría
    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;


    // Relación con préstamos
    @OneToMany(mappedBy = "libro")
    @JsonIgnoreProperties("libro") // Evita bucles Libro -> Prestamo -> Libro
    private List<Prestamo> prestamos;
}
