package com.workintech.s17d3.zoo.exceptions.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(KoalaException.class)
    public ResponseEntity<KoalaErrorResponse> handleException(KoalaException koalaException){
        KoalaErrorResponse koalaErrorResponse = new KoalaErrorResponse(koalaException.getStatus().value(),
                koalaException.getMessage(), System.currentTimeMillis());
        return new ResponseEntity<>(koalaErrorResponse, koalaException.getStatus());
    }
    @ExceptionHandler(KangarooException.class)
    public ResponseEntity<KangarooErrorResponse> handleException(KangarooException kangarooException){
        KangarooErrorResponse kangarooErrorResponse = new KangarooErrorResponse(kangarooException.getStatus().value(),
                kangarooException.getMessage(), System.currentTimeMillis());
        return new ResponseEntity<>(kangarooErrorResponse,kangarooException.getStatus());
    }
    @ExceptionHandler
    public ResponseEntity<KoalaErrorResponse> handleException(Exception exception){
        KoalaErrorResponse koalaErrorResponse = new KoalaErrorResponse(HttpStatus.BAD_REQUEST.value(),
                exception.getMessage(), System.currentTimeMillis());
        return new ResponseEntity<>(koalaErrorResponse, HttpStatus.BAD_REQUEST);
    }
}
