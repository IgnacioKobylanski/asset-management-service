package com.dev.web.api.exception;

import java.time.LocalDateTime;

public class ErrorMessage {
    public String message;
    public int statusCode;
    public LocalDateTime timestamp;

    public ErrorMessage(String message, int statusCode) {
        this.message = message;
        this.statusCode = statusCode;
        this.timestamp = LocalDateTime.now();
    }
}