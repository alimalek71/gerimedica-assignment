package com.github.alimalek.gerimedica.assignment.exception;

import org.springframework.http.HttpStatus;

public class InformationNotFound extends HttpException {
    public InformationNotFound() {
        super(HttpStatus.NOT_FOUND, "Resource not found.");
    }
}