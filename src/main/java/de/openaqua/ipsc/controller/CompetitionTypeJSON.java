package de.openaqua.ipsc.controller;

public class CompetitionTypeJSON {

	private String name;
	private String description;
	private Long id;

	public CompetitionTypeJSON(Long id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
	}

	public CompetitionTypeJSON(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}

	public CompetitionTypeJSON() {
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