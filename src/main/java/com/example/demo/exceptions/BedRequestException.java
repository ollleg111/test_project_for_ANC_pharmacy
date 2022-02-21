package com.example.demo.exceptions;

public class BedRequestException extends RuntimeException {
    public BedRequestException(String message) {
        super(message);
    }
}
