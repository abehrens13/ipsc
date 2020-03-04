package de.openaqua.ipsc.landscape;

import java.util.HashMap;
import java.util.Map;

public class NodeFactory {
	private Map<String, Node> nodeSet;
	private static final NodeFactory instanceOfNodeFactory = new NodeFactory();

	private NodeFactory() {
		super();
		this.nodeSet = new HashMap<String, Node>();

	}

	protected static NodeFactory getInstance() {
		return instanceOfNodeFactory;
	}

	public static void addNode(Node n) {
		instanceOfNodeFactory.nodeSet.put(n.getName(), n);
	}

	public static Node getNode(final String key) {
		Map<String, Node> map = instanceOfNodeFactory.nodeSet;
		if (map.containsKey(key)) {
			return map.get(key);
		} else {
			Node n = new Node(key);
			map.put(key, n);
			return n;
		}
	};

}
