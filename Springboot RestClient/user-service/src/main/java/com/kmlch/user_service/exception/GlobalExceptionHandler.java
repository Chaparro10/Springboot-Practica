package com.kmlch.user_service.exception;

import com.kmlch.user_service.models.APIError;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<APIError> handleRuntimeException(RuntimeException ex, HttpServletRequest servlet){
        HttpStatus status = HttpStatus.NOT_FOUND;
        APIError apiError = new APIError(LocalDateTime.now(),status.value(),ex.getMessage(),status.name(),servlet.getRequestURI());
        return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiError);
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<APIError> handleNullPointerException(NullPointerException ex, HttpServletRequest servlet){
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        APIError apiError = new APIError(LocalDateTime.now(),status.value(),"Something went wrong. Please try again later","A server error ocurred",servlet.getRequestURI());
        return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(apiError);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<APIError> handleValidationException(MethodArgumentNotValidException ex, HttpServletRequest servlet){
        HttpStatus status = HttpStatus.BAD_REQUEST;
        APIError apiError = new APIError(LocalDateTime.now(),
                status.value(),
               ex.getBindingResult().getFieldError().getDefaultMessage(),status.name(),servlet.getRequestURI());
        return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiError);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<APIError> handleGenericException(Exception ex, HttpServletRequest servlet){
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        APIError apiError = new APIError(LocalDateTime.now(),
                status.value(),
                "Something went wrong. Please contact suport.","Internal server error",servlet.getRequestURI());
        return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(apiError);
    }

}
