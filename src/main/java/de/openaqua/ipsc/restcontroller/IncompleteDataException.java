package de.openaqua.ipsc.restcontroller;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(org.springframework.http.HttpStatus.NOT_FOUND)
public class IncompleteDataException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6829807469013974556L;

	public IncompleteDataException() {
		super();
	}

	public IncompleteDataException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public IncompleteDataException(String message, Throwable cause) {
		super(message, cause);
	}

	public IncompleteDataException(String message) {
		super(message);
	}

	public IncompleteDataException(Throwable cause) {
		super(cause);
	}

}
