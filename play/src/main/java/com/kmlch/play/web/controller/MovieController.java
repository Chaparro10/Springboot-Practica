package com.kmlch.play.web.controller;


import com.kmlch.play.domain.dto.MovieDto;
import com.kmlch.play.domain.dto.UpdateMovieDto;
import com.kmlch.play.domain.services.MovieService;
import com.kmlch.play.persistence.entity.MovieEntity;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
@Tag(name = "Movies",description = "Operations about movies")
public class MovieController {

    private final MovieService movieService;

    public MovieController( MovieService movieService){
        this.movieService=movieService;
    }


    @GetMapping("")
    public ResponseEntity<List<MovieDto>> getAllMovies(){
        return ResponseEntity.ok(movieService.getAll());
    }

    @Operation(
            summary = "Get a movie by id",
            description ="Return movie with id send",
            responses = {
                    @ApiResponse(responseCode = "200",description = "Movie found"),
                    @ApiResponse(responseCode = "404", description = "Movie not found",content = @Content)
            }
    )
    @GetMapping("/{id}")
    public ResponseEntity<MovieDto> getById(@Parameter(description = "identifier of movie to return",example = "9") @PathVariable Long id){

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
