package com.spaient.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.mongodb.MongoWriteException;

@ControllerAdvice("com.sapient.controller")
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(MongoWriteException.class)
	@ResponseStatus(value = HttpStatus.CONFLICT)
	public ResponseEntity<ErrorResponse> handleMongoWriteException(MongoWriteException ex) {
		return new ResponseEntity<ErrorResponse>(new ErrorResponse(ex.getMessage(), HttpStatus.CONFLICT), HttpStatus.BAD_REQUEST);
		
		
	}
	
	@ExceptionHandler(TheatreAlreadyExists.class)
	public ResponseEntity<ErrorResponse> handleDuplicateKeyException(TheatreAlreadyExists ex) {
		return new ResponseEntity<ErrorResponse>(new ErrorResponse(ex.getMessage(), HttpStatus.CONFLICT), HttpStatus.BAD_REQUEST);
		
		
	}
}
