package de.openaqua.ipsc.landscape;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(org.springframework.http.HttpStatus.NOT_FOUND)
public class CityNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3220960666700252508L;

	/**
	 * 
	 */
	public CityNotFoundException() {
		super();
	}

	public CityNotFoundException(String cityName) {
		super("City " + cityName + " not found");
	}

	public CityNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public CityNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public CityNotFoundException(Throwable cause) {
		super(cause);
	}

}
