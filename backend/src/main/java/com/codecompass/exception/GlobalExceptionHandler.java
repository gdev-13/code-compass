package com.codecompass.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(EmailAlreadyExistsException.class)
	public ResponseEntity<String> handleEmailAlreadyExists(EmailAlreadyExistsException exception) {
		return ResponseEntity
				.status(HttpStatus.CONFLICT)
				.body(exception.getMessage());
	}
	
	@ExceptionHandler(InvalidCredentialsException.class)
	public ResponseEntity<String> handleInvalidCredentials(InvalidCredentialsException exception) {
		return ResponseEntity
				.status(HttpStatus.UNAUTHORIZED)
				.body(exception.getMessage());
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<String> handleValidation(
	        MethodArgumentNotValidException exception) {

	    FieldError fieldError = exception
	            .getBindingResult()
	            .getFieldError();

	    String message = fieldError.getDefaultMessage();

	    return ResponseEntity
	            .status(HttpStatus.BAD_REQUEST)
	            .body(message);
	}
}
