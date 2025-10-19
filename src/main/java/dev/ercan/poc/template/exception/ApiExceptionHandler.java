package dev.ercan.poc.template.exception;

import dev.ercan.poc.template.dto.response.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiExceptionHandler {

  @ResponseStatus(value = HttpStatus.NOT_IMPLEMENTED)
  @ExceptionHandler(value = EmailCategoryNotFoundException.class)
  public ExceptionResponse emailCategoryNotFoundExceptionException(
      EmailCategoryNotFoundException ex) {
    return new ExceptionResponse(ex.getMessage());
  }

}