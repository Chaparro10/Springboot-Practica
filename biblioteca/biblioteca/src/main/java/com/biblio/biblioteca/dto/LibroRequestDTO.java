package com.biblio.biblioteca.dto;

import lombok.Data;

@Data
public class LibroRequestDTO {
    private Long id;

    private String titulo;
    private String isbn;
    private int anioPublicacion;
    private int ejemplaresDisponibles;

    // estos son "datos derivados" de relaciones
    private Long id_categoria;
    private Long id_autor;

}
