package de.openaqua.ipsc.entities;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Shooters")
public class Shooter {

	@Id
	public String id;

	public String name;

	public String email;

	public String password;

	public String country;

	public String ipscLicence;

	public Address address;

	public List<Weapon> weapons;

	public List<String> clubs;

	public Shooter() {
		super();
		this.weapons = new ArrayList<>();
		this.clubs = new ArrayList<>();
		this.address = new Address();
		this.country = "DE";
	}

	@Override
	public String toString() {
		return "Shooter [id=" + id + ", password=" + password + ", name=" + name + ", email=" + email + ", country="
				+ country + ", ipsc_licence=" + ipscLicence + ", address=" + address + ", weapons=" + weapons
				+ ", clubs_id=" + clubs + "]";
	}

}
