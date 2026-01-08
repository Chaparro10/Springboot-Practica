package com.kmlch.play.persistence.mapper;


import com.kmlch.play.domain.dto.MovieDto;
import com.kmlch.play.domain.dto.UpdateMovieDto;
import com.kmlch.play.persistence.entity.MovieEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

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


    @Mapping(target = "titulo",source = "title")
    @Mapping(target = "fechaEstreno",source = "releaseDate")
    @Mapping(target = "clasificacion", source = "rating")
    @Mapping(target = "estado",ignore = true)
    @Mapping(target = "genero",ignore = true)
    @Mapping(target = "duracion",ignore = true)
    @Mapping(target = "id",ignore = true)
    void updateEntityFromDto(UpdateMovieDto updateMovieDto, @MappingTarget MovieEntity movie);


}
