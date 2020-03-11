package de.openaqua.ipsc.entities;

import javax.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Status {
	@Id
	private String id;

	@NotNull
	private String name_en;
	private String name_de;
	private String name_fr;

	public Status() {
		super();
	}

	public Status(String id, @NotNull String name_en, String name_de, String name_fr) {
		super();
		this.id = id;
		this.name_en = name_en;
		this.name_de = name_de;
		this.name_fr = name_fr;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName_en() {
		return name_en;
	}

	public void setName_en(String name_en) {
		this.name_en = name_en;
	}

	public String getName_de() {
		return name_de;
	}

	public void setName_de(String name_de) {
		this.name_de = name_de;
	}

	public String getName_fr() {
		return name_fr;
	}

	public void setName_fr(String name_fr) {
		this.name_fr = name_fr;
	}

}
