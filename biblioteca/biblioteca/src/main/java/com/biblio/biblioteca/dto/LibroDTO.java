package com.biblio.biblioteca.dto;


import lombok.Data;

@Data
public class LibroDTO {
    private Long id;
    private String titulo;
    private String isbn;
    private int anioPublicacion;

    // estos son "datos derivados" de relaciones
    private String nombreAutor;
    private String nombreCategoria;
}
