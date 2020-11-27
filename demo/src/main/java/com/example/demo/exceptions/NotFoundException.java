package com.example.demo.exceptions;

public class NotFoundException extends Exception {
	private final static String MSG = "NOT FOUND";
	private static final long serialVersionUID = 1L;

	public NotFoundException() {
		this(MSG);
	}

	public NotFoundException(String message) {
		super(message);
	}

	public NotFoundException(Throwable cause) {
		super(MSG, cause);
	}

	public NotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public NotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
