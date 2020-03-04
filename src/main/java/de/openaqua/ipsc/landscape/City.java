package de.openaqua.ipsc.landscape;

import java.util.Objects;

public class City extends Node //implements Comparable<City> 
{

	private String name;
	private int x;
	private int y;

	public City() {
		super();
	}

	public City(String name, int x, int y) {
		super();
		this.name = name;
		this.x = x;
		this.y = y;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(name, x, y);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (!(obj instanceof City)) {
			return false;
		}
		City other = (City) obj;
		return Objects.equals(name, other.name) && x == other.x && y == other.y;
	}


}
