package de.openaqua.ipsc.entities;

import java.math.BigInteger;

public class Money {
	public enum CurrencyType {
		EUR, USD, RUB;
	}

	private BigInteger major;
	private BigInteger minor;
	private CurrencyType currencyType;

	public Money() {
		this.major = BigInteger.ZERO;
		this.minor = BigInteger.ZERO;
		this.currencyType = CurrencyType.EUR;
	}

	public Money(BigInteger major, BigInteger minor, CurrencyType currencyType) {
		super();
		this.major = major;
		this.minor = minor;
		this.currencyType = currencyType;
	}

	public BigInteger getMajor() {
		return major;
	}

	public void setMajor(BigInteger major) {
		this.major = major;
	}

	public BigInteger getMinor() {
		return minor;
	}

	public void setMinor(BigInteger minor) {
		this.minor = minor;
	}

	public CurrencyType getCurrencyType() {
		return currencyType;
	}

	public void setCurrencyType(CurrencyType currencyType) {
		this.currencyType = currencyType;
	}

	public static Money zero() {
		return new Money();

	}

}
