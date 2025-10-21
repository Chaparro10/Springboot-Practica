package com.biblio.biblioteca.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "autores")
public class Autor {
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String apellido;
    private String nacionalidad;


    @OneToMany(mappedBy = "autor",fetch = FetchType.LAZY)
    @JsonIgnoreProperties("autor")
    private List<Libro> libros;

}
