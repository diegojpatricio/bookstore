package com.diegoptricio.bookstore.resources.exceptions;

import com.diegoptricio.bookstore.services.exceptions.ObjectNotFoundExeption;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.ServletRequest;

@ControllerAdvice
public class ResourceExepitionHandler  {

    @ExceptionHandler(ObjectNotFoundExeption.class)
    public ResponseEntity<StandarError> ObjectNotFoundExeption(ObjectNotFoundExeption e, ServletRequest request){
        StandarError error = new StandarError(System.currentTimeMillis(), HttpStatus.NOT_FOUND.value(), e.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);

    }
}
