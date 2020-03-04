package de.openaqua.ipsc.landscape;

public class Edge {
	Node nodeA;
	Node nodeB;
	int distance;

	public Edge() {
		super();
	}

	public Edge(Node nodeA, Node nodeB, int distance) {
		super();
		this.nodeA = nodeA;
		this.nodeB = nodeB;
		this.distance = distance;
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

	@Override
	public String toString() {
		return "Edge [nodeA=" + nodeA + ", nodeB=" + nodeB + ", distance=" + distance + "]";
	}

}
