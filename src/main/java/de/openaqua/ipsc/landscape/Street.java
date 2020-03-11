package de.openaqua.ipsc.landscape;

import java.util.Objects;

import org.jgrapht.graph.DefaultWeightedEdge;

public class Street extends DefaultWeightedEdge {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5918372411825711490L;

	@Override
	protected Object getSource() {
		return getNodeA();
	}

	@Override
	protected Object getTarget() {
		return getNodeB();
	}

	@Override
	protected double getWeight() {
		return getDistance();
	}

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

	@Override
	public int hashCode() {
		return Objects.hash(distance, nodeA, nodeB, streetType);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Street)) {
			return false;
		}
		Street other = (Street) obj;
		return distance == other.distance && Objects.equals(nodeA, other.nodeA) && Objects.equals(nodeB, other.nodeB)
				&& streetType == other.streetType;
	}

}
