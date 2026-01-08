package com.kmlch.play.web.controller;


import com.kmlch.play.domain.dto.MovieDto;
import com.kmlch.play.domain.dto.UpdateMovieDto;
import com.kmlch.play.domain.services.MovieService;
import com.kmlch.play.persistence.entity.MovieEntity;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("")
    public ResponseEntity<MovieDto> save( @Valid @RequestBody MovieDto movieDto){
            return ResponseEntity.status (HttpStatus.CREATED).body(this.movieService.save(movieDto));
    }
    @PatchMapping("/change")
    public ResponseEntity<MovieDto> update(@RequestParam Long id, @RequestBody @Valid UpdateMovieDto updateMovieDto){
        return ResponseEntity.ok(this.movieService.update(id,updateMovieDto));
    }
}
