package com.zaliczenie.apkawebowa.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "No such User")
public class NoSuchUserException extends RuntimeException {
    public NoSuchUserException() {
    }
}
