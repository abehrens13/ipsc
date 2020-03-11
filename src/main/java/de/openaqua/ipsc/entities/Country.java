package de.openaqua.ipsc.entities;

import javax.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Country {

	@Id
	private String id;

	@NotNull
	private String code;

	@NotNull
	private String name_en;

	private String name_fr;

	private String name_de;

	public Country(String id, @NotNull String code, @NotNull String name_en, String name_fr, String name_de) {
		super();
		this.id = id;
		this.code = code;
		this.name_en = name_en;
		this.name_fr = name_fr;
		this.name_de = name_de;
	}

	public Country(@NotNull String code, @NotNull String name_en, String name_fr, String name_de) {
		super();
		this.code = code;
		this.name_en = name_en;
		this.name_fr = name_fr;
		this.name_de = name_de;
	}

	public Country() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName_en() {
		return name_en;
	}

	public void setName_en(String name_en) {
		this.name_en = name_en;
	}

	public String getName_fr() {
		return name_fr;
	}

	public void setName_fr(String name_fr) {
		this.name_fr = name_fr;
	}

	public String getName_de() {
		return name_de;
	}

	public void setName_de(String name_de) {
		this.name_de = name_de;
	}

	@Override
	public String toString() {
		return "Country [id=" + id + ", code=" + code + ", name_en=" + name_en + ", name_fr=" + name_fr + ", name_de="
				+ name_de + "]";
	}

}