package com.example.wcrud.api.exceptions.handler;

import com.example.wcrud.api.exceptions.FileNotSupportedExcepiton;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

import static org.springframework.http.HttpStatus.NOT_ACCEPTABLE;
import static org.springframework.http.HttpStatus.NO_CONTENT;

@RestControllerAdvice
public class RestExceptionsHandler {

    @ResponseStatus(NO_CONTENT)
    @ExceptionHandler(NullPointerException.class)
    public ExceptionFilters inexistentCep(final NullPointerException ex) {
        return ExceptionFilters.builder()
                .title("Invalid CEP ! Insert a valid one")
                .details(ex.getMessage())
                .status(NO_CONTENT.value())
                .timeStamp(LocalDateTime.now())
                .build();
    }

    @ResponseStatus(NOT_ACCEPTABLE)
    @ExceptionHandler(FileNotSupportedExcepiton.class)
    public ExceptionFilters fileNotSupportedExcepiton(final FileNotSupportedExcepiton ex) {
        return ExceptionFilters.builder()
                .title("Invalid Format !")
                .details(ex.getMessage())
                .status(NOT_ACCEPTABLE.value())
                .timeStamp(LocalDateTime.now())
                .build();
    }
}
