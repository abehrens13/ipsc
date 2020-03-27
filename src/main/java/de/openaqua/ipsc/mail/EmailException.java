package de.openaqua.ipsc.mail;

public class EmailException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2913362686008555999L;

	public EmailException() {
	}

	public EmailException(String message) {
		super(message);
	}

	public EmailException(Throwable cause) {
		super(cause);
	}

	public EmailException(String message, Throwable cause) {
		super(message, cause);
	}

	public EmailException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
