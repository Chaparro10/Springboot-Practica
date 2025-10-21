package com.biblio.biblioteca.dto.mapper;


import com.biblio.biblioteca.dto.LibroDTO;
import com.biblio.biblioteca.dto.LibroRequestDTO;
import com.biblio.biblioteca.model.Libro;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface LibroMapper {

    LibroMapper mapper= Mappers.getMapper(LibroMapper.class);

    @Mapping(source = "autor.nombre", target = "nombreAutor")
    @Mapping(source = "categoria.nombre", target = "nombreCategoria")
    LibroDTO libroToLibroDTO(Libro libro);

    @Mapping(target = "autor", ignore = true)
    @Mapping(target = "categoria", ignore = true)
    Libro libroDtoToLibro(LibroRequestDTO libroRequestDTO);
}
