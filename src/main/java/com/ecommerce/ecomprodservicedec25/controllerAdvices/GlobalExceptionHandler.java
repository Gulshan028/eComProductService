package com.ecommerce.ecomprodservicedec25.controllerAdvices;

import com.ecommerce.ecomprodservicedec25.exceptions.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<String> handleProductNotFoundException(ProductNotFoundException exception){
        return new ResponseEntity<>(
                exception.getMessage(),
                HttpStatus.BAD_GATEWAY
        );
    }

//    @ExceptionHandler(ArrayIndexOutOfBoundsException.class)
//    public void handleArrayIndexOutOfBoundsException(){
//    }

//    @ExceptionHandler(Exception.class)
//    public void handleException(){
//
//    }
}
