package com.trcklst.forgetpassword.reset.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class InvalidTokenException extends ResponseStatusException {

    public InvalidTokenException() {
        super(HttpStatus.BAD_REQUEST, "The Token is not valid");
    }
}