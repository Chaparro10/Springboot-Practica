package com.kmlch.play.persistence.mapper;


import com.kmlch.play.domain.dto.MovieDto;
import com.kmlch.play.persistence.entity.MovieEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring",uses = {GenreMapper.class})
public interface MovieMapper {

    @Mapping(source = "titulo", target = "title")
    @Mapping(source = "duracion", target = "duration")
    @Mapping(source = "genero", target = "genre",qualifiedByName = "stringToGenre")
    @Mapping(source = "fechaEstreno", target = "releaseDate")
    @Mapping(source = "clasificacion", target = "rating")
    MovieDto toDto (MovieEntity movieEntity);
    List<MovieDto> toDto(List<MovieEntity> movieEntities);


    @InheritInverseConfiguration
    @Mapping(source = "genre",target = "genero",qualifiedByName = "genreToString")
    @Mapping(target = "estado",ignore = true)
    MovieEntity toEntity(MovieDto movieDto);


}
