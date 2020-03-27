package de.openaqua.ipsc.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Document("Shooters")
public class Shooter {

	@Id
	public String id;

	public String name;

	public String email;

	public String password;

	public String country;
	public String association;

	public String ipscLicence;

	public Address address;

	public List<Weapon> weapons;

	public List<String> clubs;

	public boolean dsgvo;
	@DateTimeFormat(iso = ISO.DATE_TIME)
	public Date dsgvo_date;

	public Shooter() {
		super();
		this.weapons = new ArrayList<>();
		this.clubs = new ArrayList<>();
		this.address = new Address();
		this.country = "DE";
	}

	@Override
	public String toString() {
		return "Shooter [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", country="
				+ country + ", association=" + association + ", ipscLicence=" + ipscLicence + ", address=" + address
				+ ", weapons=" + weapons + ", clubs=" + clubs + ", dsgvo=" + dsgvo + ", dsgvo_date=" + dsgvo_date + "]";
	}

	

}
