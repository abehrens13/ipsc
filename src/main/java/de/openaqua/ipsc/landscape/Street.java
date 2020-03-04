package de.openaqua.ipsc.landscape;

public class Street {
	private Node nodeA;
	private Node nodeB;
	private int distance;
	private StreetType streetType;

	public Street() {
		super();
	}

	public Street(Node nodeA, Node nodeB, int distance, StreetType streetType) {
		super();
		this.nodeA = nodeA;
		this.nodeB = nodeB;
		this.distance = distance;
		this.streetType = streetType;
	}

	public Node getNodeA() {
		return nodeA;
	}

	public void setNodeA(Node nodeA) {
		this.nodeA = nodeA;
	}

	public Node getNodeB() {
		return nodeB;
	}

	public void setNodeB(Node nodeB) {
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
