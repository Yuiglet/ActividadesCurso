package com.metaphorce.shopall.exceptions;

import lombok.*;

@Getter
@Setter
public class ErrorResponse {
    private String message;

    public ErrorResponse(String message) {
        this.message = message;
    }
}
