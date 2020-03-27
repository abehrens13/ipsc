package de.openaqua.ipsc.entities;

import javax.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class CompetitionType {

	@Override
	public String toString() {
		return "CompetitionType [id=" + id + ", name=" + name + ", description=" + description + "]";
	}

	@Id
	private String id;

	public CompetitionType(String id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
	}

	public CompetitionType(String name, String description) {
		super();
		this.id = null;
		this.name = name;
		this.description = description;
	}

	public CompetitionType() {
		super();
		this.id = null;
		this.name = null;
		this.description = null;
	}

	@NotNull
	private String name;

	private String description;

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
