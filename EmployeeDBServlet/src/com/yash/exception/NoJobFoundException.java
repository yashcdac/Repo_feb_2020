package com.yash.exception;

public class NoJobFoundException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final String message;
	public NoJobFoundException(String message) {
		this.message=message;
	}
	@Override
	public String getMessage() {
		return message;
	}
}
