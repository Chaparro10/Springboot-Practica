package com.kmlch.play.domain.exception;

public class MovieAlreadyExistsException  extends RuntimeException{

    public MovieAlreadyExistsException(String title){
        super("La pelicula " + title + " ya existe ");
    }
}
