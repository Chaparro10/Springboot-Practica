package com.kmlch.play.web.controller;


import com.kmlch.play.domain.dto.MovieDto;
import com.kmlch.play.domain.services.MovieService;
import com.kmlch.play.persistence.entity.MovieEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private final MovieService movieService;

    public MovieController( MovieService movieService){
        this.movieService=movieService;
    }


    @GetMapping("")
    public ResponseEntity<List<MovieDto>> getAllMovies(){
        return ResponseEntity.ok(movieService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieDto> getById(@PathVariable Long id){

        MovieDto movieDto = movieService.getById(id);

        if(movieDto==null){
                return  ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(movieDto);
    }
}
