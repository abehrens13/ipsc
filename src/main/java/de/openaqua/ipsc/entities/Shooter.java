package de.openaqua.ipsc.entities;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import de.openaqua.ipsc.types.CountryType;

@Document("Shooters")
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

	public List<String> clubs_id;

	public Shooter() {
		super();
		this.weapons = new ArrayList<Weapon>();
		this.clubs_id = new ArrayList<String>();
		this.address = new Address();
		this.country = CountryType.DE;
	}

}
