package de.openaqua.ipsc.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Document

public class Shooter {

	@Id
	private String id;
	private String name;
	private String email;
	private String password;
	private String country;
	private String association;
	private String ipscLicence;
	private Address address;
	private List<Weapon> weapons;
	private List<String> clubs;
	private boolean dsgvo;
	@DateTimeFormat(iso = ISO.DATE_TIME)
	private Date dsgvoDate;

	public Shooter() {
		super();
		this.weapons = new ArrayList<>();
		this.clubs = new ArrayList<>();
		this.address = new Address();
		this.country = "DE";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getAssociation() {
		return association;
	}

	public void setAssociation(String association) {
		this.association = association;
	}

	public String getIpscLicence() {
		return ipscLicence;
	}

	public void setIpscLicence(String ipscLicence) {
		this.ipscLicence = ipscLicence;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Weapon> getWeapons() {
		return weapons;
	}

	public void setWeapons(List<Weapon> weapons) {
		this.weapons = weapons;
	}

	public List<String> getClubs() {
		return clubs;
	}

	public void setClubs(List<String> clubs) {
		this.clubs = clubs;
	}

	public boolean isDsgvo() {
		return dsgvo;
	}

	public void setDsgvo(boolean dsgvo) {
		this.dsgvo = dsgvo;
	}

	public Date getDsgvoDate() {
		return dsgvoDate;
	}

	public void setDsgvoDate(Date dsgvoDate) {
		this.dsgvoDate = dsgvoDate;
	}

	@Override
	public String toString() {
		return "Shooter [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", country="
				+ country + ", association=" + association + ", ipscLicence=" + ipscLicence + ", address=" + address
				+ ", weapons=" + weapons + ", clubs=" + clubs + ", dsgvo=" + dsgvo + ", dsgvo_date=" + dsgvoDate + "]";
	}

}
