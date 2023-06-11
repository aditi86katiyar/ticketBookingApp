package com.spaient.exception;

import org.springframework.dao.DuplicateKeyException;

public class TheatreAlreadyExists extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public TheatreAlreadyExists(DuplicateKeyException e) {
		// TODO Auto-generated constructor stub
		
		super("Theatre already exists");
	}
	
	

}
