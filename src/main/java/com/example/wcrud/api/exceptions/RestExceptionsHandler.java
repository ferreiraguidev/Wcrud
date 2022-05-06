package com.example.wcrud.api.exceptions;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDateTime;

import static org.springframework.http.HttpStatus.NO_CONTENT;


public class RestExceptionsHandler {



    @ResponseStatus(NO_CONTENT)
    @ExceptionHandler(NullPointerException.class)
    public ExceptionFilters InexistentCep(final NullPointerException ex) {
        return ExceptionFilters.builder()
                .title("Invalid CEP ! Insert a valid one")
                .details(ex.getMessage())
                .status(NO_CONTENT.value())
                .timeStamp(LocalDateTime.now())
                .build();
    }


//
//    @ResponseStatus(NO_CONTENT)
//    @ExceptionHandler(NullPointerException.class)
//    public ExceptionFilters InexistentCep(final NullPointerException ex) {
//        return ExceptionFilters.builder()
//                .title("Invalid CEP ! Insert a valid one")
//                .details(ex.getMessage())
//                .status(NO_CONTENT.value())
//                .timeStamp(LocalDateTime.now())
//                .build();
//    }
}
