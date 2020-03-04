package de.openaqua.ipsc.landscape;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(org.springframework.http.HttpStatus.NOT_FOUND)
public class UnknownEnumValueException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7056326410875881729L;

	public UnknownEnumValueException(String message) {
		super(message);
	}

}
