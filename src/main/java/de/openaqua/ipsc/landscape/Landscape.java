package de.openaqua.ipsc.landscape;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class Landscape {
	Set<Edge> landscape = new HashSet<Edge>();
	private static final Log LOG = LogFactory.getLog(Landscape.class);

	public Landscape() {
		super();
	}

	protected void addTwoDirectional(String a, String b, int dist) {
		LOG.debug("addTwoDirectional: a=" + a + " b=" + b + " dist=" + dist);
		Node nodeA = NodeFactory.getNode(a);
		Node nodeB = NodeFactory.getNode(b);
		landscape.add(new Edge(nodeA, nodeB, dist));
		landscape.add(new Edge(nodeB, nodeA, dist));
	}

	protected void addOneDirectional(String a, String b, int dist) {
		LOG.debug("addOneDirectional: a=" + a + " b=" + b + " dist=" + dist);
		Node nodeA = NodeFactory.getNode(a);
		Node nodeB = NodeFactory.getNode(b);
		landscape.add(new Edge(nodeA, nodeB, dist));
	}

	Iterable<Edge> getAll() {
		LOG.debug("getAll()");
		return landscape;
	}

	Iterator<Edge> getRoute(final String from, final String to) {
		// TODO: fill in
		return landscape.iterator();
	}

	public void printLandscape() {
		LOG.debug("initGermany()");
		System.out.println("Landscape");
		Iterator<Edge> it = landscape.iterator();
		while (it.hasNext()) {
			Edge e = it.next();
			System.out.println("A-City: " + e.nodeA.getName() + "\tB-City: " + e.getNodeB().getName() + "\tDistance: "
					+ e.distance);
		}
	}

}
