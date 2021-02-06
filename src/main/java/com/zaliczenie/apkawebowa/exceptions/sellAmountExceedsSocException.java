package com.zaliczenie.apkawebowa.exceptions;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE, reason = "Not enough items in stock")
public class sellAmountExceedsSocException extends RuntimeException {
    public sellAmountExceedsSocException() {
    }
}
