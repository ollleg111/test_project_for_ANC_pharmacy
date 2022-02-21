package com.example.demo.handler;

import com.example.demo.exceptions.BedRequestException;
import com.example.demo.exceptions.InternalServerError;
import com.example.demo.exceptions.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

        @ExceptionHandler(BedRequestException.class)
    public ResponseEntity<Object> handleBedRequestException(BedRequestException e) {
        HttpStatus badRequest = HttpStatus.BAD_REQUEST;
        ErrorDetails errorDetails = new ErrorDetails(
                e.getMessage(),
                badRequest,
                ZonedDateTime.now(ZoneId.of("Z"))
        );
        return new ResponseEntity<>(errorDetails, badRequest);
    }

    @ExceptionHandler(value = InternalServerError.class)
    public ResponseEntity<Object> handleInternalServerError(InternalServerError e) {
        HttpStatus internalServerError = HttpStatus.INTERNAL_SERVER_ERROR;
        ErrorDetails errorDetails = new ErrorDetails(
                e.getMessage(),
                internalServerError,
                ZonedDateTime.now(ZoneId.of("Z"))
        );
        return new ResponseEntity<>(errorDetails, internalServerError);
    }

    @ExceptionHandler(value = NotFoundException.class)
    public ResponseEntity<Object> handleNotFoundException(NotFoundException e) {
        HttpStatus notFound = HttpStatus.NOT_FOUND;
        ErrorDetails errorDetails = new ErrorDetails(
                e.getMessage(),
                notFound,
                ZonedDateTime.now(ZoneId.of("Z"))
        );
        return new ResponseEntity<>(errorDetails, notFound);
    }
}
