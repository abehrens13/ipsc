package de.openaqua.ipsc.entities;

import org.springframework.data.mongodb.core.mapping.Document;

import de.openaqua.ipsc.types.DevisionType;
import de.openaqua.ipsc.types.PowerFactorType;

@Document("Weapons")
public class Weapon {
	public String id;
	public String gunType;
	public PowerFactorType powerFactor;
	public String serialNumber;
	public String caliber;
	public DevisionType prefDevisionType;
	
	public Weapon() {
		super();
		this.powerFactor= PowerFactorType.MAJOR;
	}
}
