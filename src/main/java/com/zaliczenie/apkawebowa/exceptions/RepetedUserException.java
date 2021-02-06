package com.zaliczenie.apkawebowa.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT, reason = "Repeted User")
public class RepetedUserException extends RuntimeException {
    public RepetedUserException() {
    }
}
