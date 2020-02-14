package de.openaqua.ipsc.entities;

public class ShooterJSON {
//	private static final Log LOG = LogFactory.getLog(Competition.class);

	private Long id;

	private String username;

	private String password;

	private String firstname;

	private String lastname;

	private String email;

	private CountryJSON country;

	private String ipsc_licence;

	public ShooterJSON(String username, String password, String firstname, String lastname, String email,
			CountryJSON country, String ipsc_licence) {
		super();
		this.username = username;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.country = country;
		this.ipsc_licence = ipsc_licence;
	}

	public ShooterJSON(Long id, String username, String password, String firstname, String lastname, String email,
			CountryJSON country, String ipsc_licence) {
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

	public ShooterJSON() {
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

	public CountryJSON getCountry() {
		return country;
	}

	public void setCountry(CountryJSON country) {
		this.country = country;
	}

	public String getIpsc_licence() {
		return ipsc_licence;
	}

	public void setIpsc_licence(String ipsc_licence) {
		this.ipsc_licence = ipsc_licence;
	}

}
