package com.devsuperior.CRUD_Clientes_Challenge03.controllers.handlers;

import com.devsuperior.CRUD_Clientes_Challenge03.DTO.CustomError;
import com.devsuperior.CRUD_Clientes_Challenge03.DTO.ValidationError;
import com.devsuperior.CRUD_Clientes_Challenge03.services.exceptions.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ControllerExceptionsHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<CustomError> ResourceNotFound(ResourceNotFoundException e, HttpServletRequest request){
        HttpStatus status = HttpStatus.NOT_FOUND;
        CustomError customError = new CustomError(Instant.now(), status.value(), e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(customError);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<CustomError> methodArgumentNotValidation(MethodArgumentNotValidException e, HttpServletRequest request){
        HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;
        ValidationError validationError = new ValidationError(Instant.now(), status.value(), "Dados inválidos", request.getRequestURI());

        for(FieldError f : e.getBindingResult().getFieldErrors()){
            validationError.addError(f.getField(), f.getDefaultMessage());
        }

        return ResponseEntity.status(status).body(validationError);
    }

}
