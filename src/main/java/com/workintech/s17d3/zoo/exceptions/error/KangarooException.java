package com.workintech.s17d3.zoo.exceptions.error;

import lombok.Getter;
import org.springframework.http.HttpStatus;
@Getter
public class KangarooException extends RuntimeException {

    public HttpStatus status;

    public KangarooException(String message, HttpStatus status){
        super(message);
        this.status = status;
    }
}
