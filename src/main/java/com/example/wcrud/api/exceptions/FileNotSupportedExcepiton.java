package com.example.wcrud.api.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.http.HttpStatus.NOT_ACCEPTABLE;

@ResponseStatus(NOT_ACCEPTABLE)
public class FileNotSupportedExcepiton extends RuntimeException {

    public FileNotSupportedExcepiton(String s) {
        super(s);
    }
}
