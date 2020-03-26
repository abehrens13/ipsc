package de.openaqua.ipsc.entities;

public class Address {
	private String id;
	private String street;
	private String country;
	private String city;
	private String postCode;

	public Address() {
		super();
		this.country = "DE";
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", street=" + street + ", country=" + country + ", city=" + city + ", postCode="
				+ postCode + "]";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

}
