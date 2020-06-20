package com.trcklst.forgetpassword.send.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class EmailNotExistsException extends ResponseStatusException {

    public EmailNotExistsException(String email) {
        super(HttpStatus.NOT_FOUND, String.format("Email %s is not found", email));
    }
}
