package com.kmlch.play.web.controller;


import com.kmlch.play.domain.dto.MovieDto;
import com.kmlch.play.domain.services.MovieService;
import com.kmlch.play.persistence.entity.MovieEntity;
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
    public List<MovieDto> getAllMovies(){
        return movieService.getAll();
    }

    @GetMapping("/{id}")
    public MovieDto getById(@PathVariable Long id){
        return movieService.getById(id);
    }
}
