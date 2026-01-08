package com.kmlch.play.web.exception;


import com.kmlch.play.domain.exception.MovieAlreadyExistsException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(MovieAlreadyExistsException.class)
    public ResponseEntity<Error> handleException(MovieAlreadyExistsException ex){
        Error error = new Error("movie",ex.getMessage());
        return  ResponseEntity.badRequest().body(error);
    }

    //Este entra en las validaciones de Validation(@Valid)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<Error>> handleExceptionValidator(MethodArgumentNotValidException e){
                List<Error> errors=new ArrayList<>();

                e.getBindingResult().getFieldErrors().forEach(error->{
                    errors.add(new Error(error.getField(),error.getDefaultMessage()));
                });
                return ResponseEntity.badRequest().body(errors);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Error> handleExceptionGeneral(Exception e){
        Error error = new Error("UNKNOWN-ERROR",e.getMessage());
        e.printStackTrace();
        return ResponseEntity.internalServerError().body(error);
    }
}
