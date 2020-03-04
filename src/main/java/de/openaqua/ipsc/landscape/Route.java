package de.openaqua.ipsc.landscape;

import java.util.Collection;

public class Route {
	private City from;
	private City to;
	private int distance;
	private int driveMinutes; // in minutes
	private Collection<Street> route;
	private int beeline;
	private VehicleType vehicleType;

	public VehicleType getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(VehicleType vehicleType) {
		this.vehicleType = vehicleType;
	}

	public int getBeeline() {
		return beeline;
	}

	public void setBeeline(double beeline) {
		this.beeline = new Double(beeline).intValue();
	}

	public Route(City from, City to, VehicleType vehicleType) {
		super();
		this.from = from;
		this.to = to;
		this.vehicleType = vehicleType;
	}

	public City getFrom() {
		return from;
	}

	public void setFrom(City from) {
		this.from = from;
	}

	public City getTo() {
		return to;
	}

	public void setTo(City to) {
		this.to = to;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public int getDriveMinutes() {
		return driveMinutes;
	}

	public void setDriveMinutes(int driveMinutes) {
		this.driveMinutes = driveMinutes;
	}

	public Collection<Street> getRoute() {
		return route;
	}

	public void setRoute(Collection<Street> route) {
		this.route = route;
	}

}
