package de.openaqua.ipsc.entities;

import java.util.ArrayList;
import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import com.mongodb.lang.NonNull;

@Document("Clubs")
public class Club {

	@Id
	public String id;

	public String name;

	public String website;

	@NonNull
	public String email;

	public Address address;

	public List<String> competitions;
	public List<String> members;

	public Club() {
		super();
		this.competitions = new ArrayList<String>();
		this.members = new ArrayList<String>();
		this.address = new Address();
	}
}
