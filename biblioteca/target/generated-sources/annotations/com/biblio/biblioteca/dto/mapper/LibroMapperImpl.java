package com.biblio.biblioteca.dto.mapper;

import com.biblio.biblioteca.dto.LibroDTO;
import com.biblio.biblioteca.dto.LibroRequestDTO;
import com.biblio.biblioteca.model.Autor;
import com.biblio.biblioteca.model.Categoria;
import com.biblio.biblioteca.model.Libro;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-10-21T15:43:00-0700",
    comments = "version: 1.6.3, compiler: javac, environment: Java 17.0.13 (Amazon.com Inc.)"
)
@Component
public class LibroMapperImpl implements LibroMapper {

    @Override
    public LibroDTO libroToLibroDTO(Libro libro) {
        if ( libro == null ) {
            return null;
        }

        LibroDTO libroDTO = new LibroDTO();

        libroDTO.setNombreAutor( libroAutorNombre( libro ) );
        libroDTO.setNombreCategoria( libroCategoriaNombre( libro ) );
        libroDTO.setId( libro.getId() );
        libroDTO.setTitulo( libro.getTitulo() );
        libroDTO.setIsbn( libro.getIsbn() );
        libroDTO.setAnioPublicacion( libro.getAnioPublicacion() );

        return libroDTO;
    }

    @Override
    public Libro libroDtoToLibro(LibroRequestDTO libroRequestDTO) {
        if ( libroRequestDTO == null ) {
            return null;
        }

        Libro libro = new Libro();

        libro.setId( libroRequestDTO.getId() );
        libro.setTitulo( libroRequestDTO.getTitulo() );
        libro.setIsbn( libroRequestDTO.getIsbn() );
        libro.setAnioPublicacion( libroRequestDTO.getAnioPublicacion() );
        libro.setEjemplaresDisponibles( libroRequestDTO.getEjemplaresDisponibles() );

        return libro;
    }

    private String libroAutorNombre(Libro libro) {
        Autor autor = libro.getAutor();
        if ( autor == null ) {
            return null;
        }
        return autor.getNombre();
    }

    private String libroCategoriaNombre(Libro libro) {
        Categoria categoria = libro.getCategoria();
        if ( categoria == null ) {
            return null;
        }
        return categoria.getNombre();
    }
}
