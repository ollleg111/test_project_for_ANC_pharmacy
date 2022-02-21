package com.example.demo.handler;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

@Setter
@Getter
@AllArgsConstructor
public class ErrorDetails {
    private final String message;
    private final HttpStatus httpStatus;
    private final ZonedDateTime timestamp;
}
