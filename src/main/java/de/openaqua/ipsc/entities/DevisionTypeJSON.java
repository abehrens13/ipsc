package de.openaqua.ipsc.entities;

public class DevisionTypeJSON {

	private String name;
	private String description;
	private Long id;

	public DevisionTypeJSON(Long id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
	}

	public DevisionTypeJSON(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}

	public DevisionTypeJSON() {
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