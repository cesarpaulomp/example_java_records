package com.example.records.infra.configuration;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.records.infra.dto.DefaultErrorResponse;

import feign.FeignException;

@RestControllerAdvice
public class FeignExceptionHandler {
  @ExceptionHandler(FeignException.class)
  public ResponseEntity<DefaultErrorResponse> handleFeignException(FeignException ex) {

    HttpStatus status = HttpStatus.resolve(ex.status());
    if (status == null) {
      status = HttpStatus.INTERNAL_SERVER_ERROR;
    }

    return ResponseEntity.status(status).body(new DefaultErrorResponse(status.value(), ex.getMessage()));
  }
}
