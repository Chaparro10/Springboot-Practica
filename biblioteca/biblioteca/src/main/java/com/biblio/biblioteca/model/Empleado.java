package com.biblio.biblioteca.model;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
@Table(name = "empleados")
public class Empleado {
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombreUsuario;
    private String password;
    private String rol;
}
