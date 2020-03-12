package de.openaqua.ipsc.entities;

import org.springframework.data.mongodb.core.mapping.Document;

@Document("Weapons")
public class Weapon {
	public String id;
	public String gunType;
	public PowerFactorType powerFactor;
	public String serialNumber;
	public String caliber;
	public DevisionType prefDevisionType;

}
