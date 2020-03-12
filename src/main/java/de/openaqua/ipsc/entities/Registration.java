package de.openaqua.ipsc.entities;

import java.util.Date;

import org.joda.money.Money;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Registrations")
public class Registration {
	public String id;
	public String shooterId;
	public String competitionId;
	public Date registrationDate;
	public Money paymentAmount;
	public Date paymentDate;

	public Registration() {
		super();
		this.paymentDate = null;
		this.paymentAmount = Money.parse("EUR 0.00");
	}

}
