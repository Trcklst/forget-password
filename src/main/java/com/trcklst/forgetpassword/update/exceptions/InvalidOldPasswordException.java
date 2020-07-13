package com.trcklst.forgetpassword.update.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Old password does not match")
public class InvalidOldPasswordException extends RuntimeException {
}
