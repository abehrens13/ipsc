package de.openaqua.ipsc.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/*
 * 
CREATE TABLE SHOOTERS(ID SERIAL,
		USERNAME VARCHAR(20) NOT NULL UNIQUE,
		PASSWORDSTR VARCHAR(50) NOT NULL,
		FIRSTNAME VARCHAR(40),
		LASTNAME VARCHAR(40),
		EMAIL VARCHAR(50),
		COUNTRY_ID NUMERIC NOT NULL,
		IPSC_LICENCE VARCHAR(20));

*/

@Entity
@Table(name = "shooters")
public class Shooter {
//	private static final Log LOG = LogFactory.getLog(Competition.class);

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@NotNull
	@Column(name = "username")
	private String username;

	@NotNull
	@Column(name = "passwordstr")
	private String password;

	@NotNull
	@Column(name = "firstname")
	private String firstname;

	@NotNull
	@Column(name = "lastname")
	private String lastname;

	@NotNull
	@Column(name = "email")
	private String email;

	@NotNull
	@ManyToOne(cascade = CascadeType.ALL)
	private Country country;

	@Column(name = "ipsc_licence")
	private String ipsc_licence;

	public Shooter(@NotNull String username, @NotNull String password, @NotNull String firstname,
			@NotNull String lastname, @NotNull String email, @NotNull Country country, String ipsc_licence) {
		super();
		this.username = username;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.country = country;
		this.ipsc_licence = ipsc_licence;
	}

	public Shooter(Long id, @NotNull String username, @NotNull String password, @NotNull String firstname,
			@NotNull String lastname, @NotNull String email, @NotNull Country country, String ipsc_licence) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.country = country;
		this.ipsc_licence = ipsc_licence;
	}

	public Shooter() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public String getIpsc_licence() {
		return ipsc_licence;
	}

	public void setIpsc_licence(String ipsc_licence) {
		this.ipsc_licence = ipsc_licence;
	}

}
