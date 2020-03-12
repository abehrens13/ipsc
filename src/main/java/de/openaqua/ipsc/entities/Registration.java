package de.openaqua.ipsc.entities;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

@Document("Registrations")
public class Registration {
	public String id;
	public String shooterId;
	public String competitionId;
	public Date registrationDate;
	public Money paymentAmount;
	public Date paymentDate;
	public Weapon weapon;

	public Registration(String shooterId, String competitionId) {
		super();
		this.shooterId = shooterId;
		this.competitionId = competitionId;

		this.registrationDate = new Date();
		this.paymentDate = null;
		this.paymentAmount = Money.zero();
		this.weapon = null;

	}

	public Registration() {
		super();
		this.registrationDate = new Date();
		this.paymentDate = null;
		this.paymentAmount = Money.zero();
		this.weapon = null;
	}

}
