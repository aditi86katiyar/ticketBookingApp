package com.spaient.exception;

import org.springframework.http.HttpStatus;

public class ErrorResponse {
	
	int value;
	String message;
	HttpStatus conflict;

	public ErrorResponse(String message, HttpStatus conflict) {
		super();
		this.message=message;
		this.conflict=conflict;
	}

}
