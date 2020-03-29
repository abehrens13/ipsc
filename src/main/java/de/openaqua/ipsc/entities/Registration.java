package de.openaqua.ipsc.entities;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

@Document("Registrations")
public class Registration implements IDocument {
	private String id;
	private String shooterId;
	private String competitionId;
	private Date registrationDate;
	private Money paymentAmount;
	private Date paymentDate;
	private Weapon weapon;

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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getShooterId() {
		return shooterId;
	}

	public void setShooterId(String shooterId) {
		this.shooterId = shooterId;
	}

	public String getCompetitionId() {
		return competitionId;
	}

	public void setCompetitionId(String competitionId) {
		this.competitionId = competitionId;
	}

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	public Money getPaymentAmount() {
		return paymentAmount;
	}

	public void setPaymentAmount(Money paymentAmount) {
		this.paymentAmount = paymentAmount;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	public Weapon getWeapon() {
		return weapon;
	}

	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}

	@Override
	public String toString() {
		return "Registration [id=" + id + ", shooterId=" + shooterId + ", competitionId=" + competitionId
				+ ", registrationDate=" + registrationDate + ", paymentAmount=" + paymentAmount + ", paymentDate="
				+ paymentDate + ", weapon=" + weapon + "]";
	}

}
