/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.neoinfo.shared.exception;

import com.neoinfo.modulos.rrhh.exception.PersonaAlreadyExistsException;
import com.neoinfo.modulos.rrhh.exception.PersonaNotFoundException;
import com.neoinfo.shared.dto.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 *
 * @author blackshadow
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(PersonaAlreadyExistsException.class)
    public ResponseEntity<ApiResponse<Object>> handleAlreadyExists(PersonaAlreadyExistsException ex) {
        return new ResponseEntity<>(new ApiResponse<>(false, ex.getMessage(), null), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(PersonaNotFoundException.class)
    public ResponseEntity<ApiResponse<Object>> handleNotFound(PersonaNotFoundException ex) {
        return new ResponseEntity<>(new ApiResponse<>(false, ex.getMessage(), null), HttpStatus.NOT_FOUND);
    }
}
