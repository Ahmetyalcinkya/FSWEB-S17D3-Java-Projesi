package com.workintech.s17d3.zoo.exceptions.error;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class ZooException extends RuntimeException {

    private HttpStatus status;
    public ZooException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }
}
