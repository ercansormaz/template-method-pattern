package dev.ercan.poc.template.exception;

public class EmailCategoryNotFoundException extends RuntimeException {

  public EmailCategoryNotFoundException(String message) {
    super(message);
  }

}