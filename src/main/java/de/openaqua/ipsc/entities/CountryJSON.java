package de.openaqua.ipsc.entities;

public class CountryJSON {
	private Long id;

	private String code;

	private String name_en;

	private String name_fr;

	private String name_de;

	public CountryJSON(Long id, String code, String name_en, String name_fr, String name_de) {
		super();
		this.id = id;
		this.code = code;
		this.name_en = name_en;
		this.name_fr = name_fr;
		this.name_de = name_de;
	}

	public CountryJSON(String code, String name_en, String name_fr, String name_de) {
		super();
		this.code = code;
		this.name_en = name_en;
		this.name_fr = name_fr;
		this.name_de = name_de;
	}

	public CountryJSON() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

}