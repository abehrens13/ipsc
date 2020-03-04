package de.openaqua.ipsc.landscape;

import java.util.Objects;

public class Node {

	private String name;

	public Node() {
		super();
	}

	public Node(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Node)) {
			return false;
		}
		Node other = (Node) obj;
		return Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "Node [name=" + name + "]";
	}

}
