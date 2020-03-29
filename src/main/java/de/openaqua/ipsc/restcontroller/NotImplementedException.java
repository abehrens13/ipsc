package de.openaqua.ipsc.restcontroller;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(org.springframework.http.HttpStatus.NOT_FOUND)
public class NotImplementedException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6829807469013974556L;

	public NotImplementedException() {
		super();
	}

	public NotImplementedException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public NotImplementedException(String message, Throwable cause) {
		super(message, cause);
	}

	public NotImplementedException(String message) {
		super(message);
	}

	public NotImplementedException(Throwable cause) {
		super(cause);
	}

}
