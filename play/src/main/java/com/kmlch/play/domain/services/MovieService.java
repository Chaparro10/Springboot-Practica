package com.kmlch.play.domain.services;


import com.kmlch.play.domain.dto.MovieDto;
import com.kmlch.play.persistence.crud.CrudMovieEntity;
import com.kmlch.play.persistence.entity.MovieEntity;
import com.kmlch.play.persistence.mapper.MovieMapper;
import org.springframework.stereotype.Service;

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


}
