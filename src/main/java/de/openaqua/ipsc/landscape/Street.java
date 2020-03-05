package de.openaqua.ipsc.landscape;

public class Street {
	private City nodeA;
	private City nodeB;
	private int distance;
	private StreetType streetType;

	public Street() {
		super();
	}

	public Street(City nodeA, City nodeB, int distance, StreetType streetType) {
		super();
		this.nodeA = nodeA;
		this.nodeB = nodeB;
		this.distance = distance;
		this.streetType = streetType;
	}

	public City getNodeA() {
		return nodeA;
	}

	public void setNodeA(City nodeA) {
		this.nodeA = nodeA;
	}

	public City getNodeB() {
		return nodeB;
	}

	public void setNodeB(City nodeB) {
		this.nodeB = nodeB;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public StreetType getStreetType() {
		return streetType;
	}

	public void setStreetType(StreetType streetType) {
		this.streetType = streetType;
	}

	@Override
	public String toString() {
		return "Edge [nodeA=" + nodeA + ", nodeB=" + nodeB + ", distance=" + distance + ", streetType=" + streetType
				+ "]";
	}

}
