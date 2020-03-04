package de.openaqua.ipsc.landscape;

public class City extends Node {

	private int x;
	private int y;

	public City() {
		super();
	}

	public City(String name, int x, int y) {
		super(name);
		this.x = x;
		this.y = y;
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
	public String toString() {
		return "City [name=" + getName() + ", x=" + x + ", y=" + y + "]";
	}

}
