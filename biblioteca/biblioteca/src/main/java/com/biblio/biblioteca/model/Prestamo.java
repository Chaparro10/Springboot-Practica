package com.biblio.biblioteca.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "prestamos")
public class Prestamo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Relación con Usuario
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    @JsonIgnoreProperties("prestamos") // evita bucle Usuario -> Prestamo -> Usuario
    private Usuario usuario;

    // Relación con Libro
    @ManyToOne
    @JoinColumn(name = "libro_id")
    @JsonIgnoreProperties("prestamos") // evita bucle Libro -> Prestamo -> Libro
    private Libro libro;

    private LocalDate fechaPrestamo;
    private LocalDate fechaDevolucion;
    private boolean devuelto;
}
