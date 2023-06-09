package com.cgi.exception;

public class MovieException extends RuntimeException {
	
	public MovieException() {
		super();
	}

	public MovieException(String error) {
		super(error);
	}
}
