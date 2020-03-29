package de.openaqua.ipsc.entities;

import java.util.Objects;

public class LoginToken {
	String token;

	@Override
	public int hashCode() {
		return Objects.hash(token);
	}

	public LoginToken() {
		super();
	}

	public LoginToken(String token) {
		super();
		this.token = token;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof LoginToken)) {
			return false;
		}
		LoginToken other = (LoginToken) obj;
		return Objects.equals(token, other.token);
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}
