package de.openaqua.ipsc.landscape;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class Landscape {
	Set<Edge> landscape = new HashSet<Edge>();
	private static final Log LOG = LogFactory.getLog(Landscape.class);

	@Autowired
	CityFactory cityFactory;

	public Landscape() {
		super();
	}

	protected void addTwoDirectional(String a, String b, int dist) {
		City nodeA = cityFactory.getCity(a);
		City nodeB = cityFactory.getCity(b);
		landscape.add(new Edge(nodeA, nodeB, dist));
		landscape.add(new Edge(nodeB, nodeA, dist));
	}

	protected void addOneDirectional(String a, String b, int dist) {
		City nodeA = cityFactory.getCity(a);
		City nodeB = cityFactory.getCity(b);
		landscape.add(new Edge(nodeA, nodeB, dist));
	}

	Iterator<Edge> getAll() {
		LOG.debug("getAll()");
		return landscape.iterator();
	}

	@PostConstruct
	public void postConstructInit() {
		LOG.debug("postConstructInit");
		addTwoDirectional("Bochum", "Essen", 20);
		addTwoDirectional("Essen", "Remscheid", 20);
		addTwoDirectional("Essen", "Düsseldorf", 30);
		addTwoDirectional("Düsseldorf", "Meerbusch", 10);
		addTwoDirectional("Düsseldorf", "Neuss", 10);
		addTwoDirectional("Düsseldorf", "Leverkusen", 10);
		addTwoDirectional("Düsseldorf", "Köln", 30);
		addTwoDirectional("Leverkusen", "Bonn", 10);
		addTwoDirectional("Bonn", "Siegburg", 10);
		addTwoDirectional("Wuppertal", "Essen", 20);
		addTwoDirectional("Wuppertal", "Leverkusen", 15);
		addTwoDirectional("Wuppertal", "Düsseldorf", 10);
		addTwoDirectional("Köln", "Koblenz", 100);
		addTwoDirectional("Köln", "Bonn", 40);
		addTwoDirectional("Aachen", "Köln", 100);
		addTwoDirectional("Aachen", "Neuss", 90);
	}

	Iterator<Edge> getRoute(final String from, final String to) {
		LOG.debug("getRoute");
		// TODO: fill in
		return landscape.iterator();
	}

	public void printLandscape() {
		LOG.debug("printLandscape");
		Iterator<Edge> it = landscape.iterator();
		while (it.hasNext()) {
			Edge e = it.next();
			System.out.println("A-City: " + e.nodeA.getName() + "\tB-City: " + e.getNodeB().getName() + "\tDistance: "
					+ e.distance);
		}
	}

}
