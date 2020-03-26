package de.openaqua.ipsc.restcontroller;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(org.springframework.http.HttpStatus.NOT_FOUND)
public class NoSuchCompetitionException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6829807469013974556L;

	public NoSuchCompetitionException() {
		super();
	}

	public NoSuchCompetitionException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public NoSuchCompetitionException(String message, Throwable cause) {
		super(message, cause);
	}

	public NoSuchCompetitionException(String message) {
		super(message);
	}

	public NoSuchCompetitionException(Throwable cause) {
		super(cause);
	}

}
