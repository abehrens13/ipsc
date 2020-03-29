package de.openaqua.ipsc.entities;

import java.util.ArrayList;
import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import com.mongodb.lang.NonNull;

@Document("Clubs")
public class Club implements IDocument {

	@Id
	private String id;

	private String name;

	private String website;

	@NonNull
	private String email;

	private Address address;

	private List<String> competitions;
	private List<String> members;

	public Club() {
		super();
		this.competitions = new ArrayList<>();
		this.members = new ArrayList<>();
		this.address = new Address();
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

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<String> getCompetitions() {
		return competitions;
	}

	public void setCompetitions(List<String> competitions) {
		this.competitions = competitions;
	}

	public List<String> getMembers() {
		return members;
	}

	public void setMembers(List<String> members) {
		this.members = members;
	}

	@Override
	public String toString() {
		return "Club [id=" + id + ", name=" + name + ", website=" + website + ", email=" + email + ", address="
				+ address + ", competitions=" + competitions + ", members=" + members + "]";
	}

}
