package de.openaqua.ipsc.controller;

public class CompetitionJSON {

	private String name;
	private String description;
	private Long id;

	public CompetitionJSON(String name, String description, Long id) {
		super();
		this.name = name;
		this.description = description;
		this.id = id;
	}

	public CompetitionJSON(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}

	public CompetitionJSON() {
		super();
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}