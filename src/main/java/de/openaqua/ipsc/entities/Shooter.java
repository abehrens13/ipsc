package de.openaqua.ipsc.entities;

import javax.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Shooter {

	@Id
	private String id;

	@NotNull
	private String username;

	@NotNull
	private String password;

	@NotNull
	private String firstname;

	@NotNull
	private String lastname;

	@NotNull
	private String email;

	@NotNull
	private String country;

	private String ipsc_licence;

	public Shooter(String id, @NotNull String username, @NotNull String password, @NotNull String firstname,
			@NotNull String lastname, @NotNull String email, @NotNull String country, String ipsc_licence) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.country = country;
		this.ipsc_licence = ipsc_licence;
	}

	public Shooter(@NotNull String username, @NotNull String password, @NotNull String firstname,
			@NotNull String lastname, @NotNull String email, @NotNull String country, String ipsc_licence) {
		super();
		this.username = username;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.country = country;
		this.ipsc_licence = ipsc_licence;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getIpsc_licence() {
		return ipsc_licence;
	}

	public void setIpsc_licence(String ipsc_licence) {
		this.ipsc_licence = ipsc_licence;
	}

	@Override
	public String toString() {
		return "Shooter [id=" + id + ", username=" + username + ", password=" + password + ", firstname=" + firstname
				+ ", lastname=" + lastname + ", email=" + email + ", country=" + country + ", ipsc_licence="
				+ ipsc_licence + "]";
	}

}
