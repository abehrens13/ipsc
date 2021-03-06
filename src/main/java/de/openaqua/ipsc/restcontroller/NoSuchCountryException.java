package de.openaqua.ipsc.restcontroller;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus ( org.springframework.http.HttpStatus.NOT_FOUND) 
public class NoSuchCountryException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6829807469013974556L;

	public NoSuchCountryException() {
		super();
	}

	public NoSuchCountryException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public NoSuchCountryException(String message, Throwable cause) {
		super(message, cause);
	}

	public NoSuchCountryException(String message) {
		super(message);
	}

	public NoSuchCountryException(Throwable cause) {
		super(cause);
	}

	
}
