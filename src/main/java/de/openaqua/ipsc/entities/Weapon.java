package de.openaqua.ipsc.entities;

import de.openaqua.ipsc.types.DevisionType;
import de.openaqua.ipsc.types.PowerFactorType;

public class Weapon {
	private String id;
	private String gunType;
	private PowerFactorType powerFactor;
	private String serialNumber;
	private String caliber;
	private DevisionType prefDevisionType;

	public Weapon() {
		super();
		this.powerFactor = PowerFactorType.MAJOR;
		this.prefDevisionType = DevisionType.PRODUCTION;
	}

	@Override
	public String toString() {
		return "Weapon [id=" + id + ", gunType=" + gunType + ", powerFactor=" + powerFactor + ", serialNumber="
				+ serialNumber + ", caliber=" + caliber + ", prefDevisionType=" + prefDevisionType + "]";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getGunType() {
		return gunType;
	}

	public void setGunType(String gunType) {
		this.gunType = gunType;
	}

	public PowerFactorType getPowerFactor() {
		return powerFactor;
	}

	public void setPowerFactor(PowerFactorType powerFactor) {
		this.powerFactor = powerFactor;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getCaliber() {
		return caliber;
	}

	public void setCaliber(String caliber) {
		this.caliber = caliber;
	}

	public DevisionType getPrefDevisionType() {
		return prefDevisionType;
	}

	public void setPrefDevisionType(DevisionType prefDevisionType) {
		this.prefDevisionType = prefDevisionType;
	}

}
