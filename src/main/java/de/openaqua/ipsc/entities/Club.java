package de.openaqua.ipsc.entities;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Clubs")
public class Club {

	@Id
	public String id;

	@NotNull
	public String name;

	public String website;

	@NotNull
	public String email;

	public Address address;
	
	public List<String> competitions;
	public List<String> members;
	public Club() {
		super();
		this.competitions = new ArrayList<String>();
		this.members=new ArrayList<String>();  
		this.address = new Address();
	}
}
