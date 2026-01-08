package com.kmlch.play.domain.services;


import com.kmlch.play.domain.dto.MovieDto;
import com.kmlch.play.domain.dto.UpdateMovieDto;
import com.kmlch.play.persistence.crud.CrudMovieEntity;
import com.kmlch.play.persistence.entity.MovieEntity;
import com.kmlch.play.persistence.mapper.MovieMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class MovieService {


    private final CrudMovieEntity crudMovieEntity;
    private final MovieMapper movieMapper;

    //inyeccion por constructor
    public MovieService(CrudMovieEntity crudMovieEntity,MovieMapper movieMapper){
        this.crudMovieEntity=crudMovieEntity;
        this.movieMapper=movieMapper;
    }


    public List<MovieDto> getAll(){
        return  movieMapper.toDto(this.crudMovieEntity.findAll());
    }

    public MovieDto getById(Long id){
        System.out.println(id);
        return movieMapper.toDto(this.crudMovieEntity.findById(id).orElse(null));
    }

    public MovieDto save(MovieDto movieDto){
        MovieEntity movieEntity = movieMapper.toEntity(movieDto);
        movieEntity.setEstado("D");
        return  movieMapper.toDto(this.crudMovieEntity.save(movieEntity));
    }

    public MovieDto update(Long id, UpdateMovieDto updateMovieDto){
       MovieEntity movieEntity= this.crudMovieEntity.findById(id).orElse(null);

       if(movieEntity==null) return  null;
//
//       movieEntity.setTitulo(updateMovieDto.title());
//       movieEntity.setFechaEstreno(updateMovieDto.releaseDate());
//       movieEntity.setClasificacion(BigDecimal.valueOf(updateMovieDto.rating()));
//
   this.movieMapper.updateEntityFromDto(updateMovieDto,movieEntity);
    MovieEntity movie =   this.crudMovieEntity.save(movieEntity);
       return this.movieMapper.toDto(movie);
    }


}
