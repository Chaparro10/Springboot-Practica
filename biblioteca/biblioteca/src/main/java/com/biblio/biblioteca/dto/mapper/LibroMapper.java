package com.biblio.biblioteca.dto.mapper;


import com.biblio.biblioteca.dto.LibroDTO;
import com.biblio.biblioteca.dto.LibroRequestDTO;
import com.biblio.biblioteca.model.Libro;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface LibroMapper {

    @Mapping(source = "autor.nombre", target = "nombreAutor")
    @Mapping(source = "categoria.nombre", target = "nombreCategoria")
    LibroDTO libroToLibroDTO(Libro libro);

    @Mapping(target = "autor", ignore = true)
    @Mapping(target = "categoria", ignore = true)
    Libro libroDtoToLibro(LibroRequestDTO libroRequestDTO);
}
