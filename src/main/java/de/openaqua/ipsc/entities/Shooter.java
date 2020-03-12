package de.openaqua.ipsc.entities;

import java.util.List;

import javax.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Shooter")
public class Shooter {

	@Id
	public String id;

	@NotNull
	public String username;

	@NotNull
	public String password;

	@NotNull
	public String firstname;

	@NotNull
	public String lastname;

	@NotNull
	public String email;

	@NotNull
	public CountryType country;

	public String ipsc_licence;

	public Address address;

	public List<Weapon> weapons;

	public Shooter() {
		super();
	}

}
