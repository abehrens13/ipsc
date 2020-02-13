package de.openaqua.ipsc.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "devision_type")
public class DevisionType {
//	private static final Log LOG = LogFactory.getLog(Competition.class);

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	public DevisionType(Long id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
	}

	public DevisionType(String name, String description) {
		super();
		this.id = null;
		this.name = name;
		this.description = description;
	}

	public DevisionType() {
		super();
		this.id = null;
		this.name = null;
		this.description = null;
	}

	@NotNull
	@Column(name = "name")
	private String name;

	@Column(name = "description")
	private String description;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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
