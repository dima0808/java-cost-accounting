package com.example.lab2.api.controller;

import static java.net.URI.create;
import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.ProblemDetail.forStatusAndDetail;

import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionTranslator {

  @ExceptionHandler(IllegalArgumentException.class)
  public ResponseEntity<ProblemDetail> handleProductNotFoundException(IllegalArgumentException ex) {
    ProblemDetail problemDetail = forStatusAndDetail(BAD_REQUEST, ex.getMessage());
    problemDetail.setType(create("illegal-arguments"));
    problemDetail.setTitle(BAD_REQUEST.getReasonPhrase());
    return ResponseEntity.status(BAD_REQUEST).body(problemDetail);
  }
}
