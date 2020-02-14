package de.openaqua.ipsc.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/*
 * CREATE TABLE COUNTRIES(ID SERIAL,
CODE CHAR(3) NOT NULL UNIQUE,
NAME_EN VARCHAR(50) NOT NULL UNIQUE,
NAME_DE VARCHAR(50),
NAME_FR VARCHAR(50))
 */

@Entity
@Table(name = "countries")
public class Country {
//	private static final Log LOG = LogFactory.getLog(Competition.class);

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@NotNull
	@Column(name = "code")
	private String code;

	@NotNull
	@Column(name = "name_en")
	private String name_en;

	@Column(name = "name_fr")
	private String name_fr;

	@Column(name = "name_de")
	private String name_de;

	public Country(Long id, @NotNull String code, @NotNull String name_en, String name_fr, String name_de) {
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

	@Override
	public String toString() {
		return "Country [id=" + id + ", code=" + code + ", name_en=" + name_en + ", name_fr=" + name_fr + ", name_de="
				+ name_de + "]";
	}

}