package com.bjs.cv.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Lat and Long already Exists")
public class IDNotFoundException extends RuntimeException {
    public IDNotFoundException(String message){
        super(message);
    }
}
