package de.openaqua.ipsc.landscape;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class Landscape {
	Set<Street> landscape = new HashSet<Street>();
	private static final Log LOG = LogFactory.getLog(Landscape.class);

	@Autowired
	CityFactory cityFactory;

	public Landscape() {
		super();
	}

	protected void addTwoDirectional(String a, String b, int dist, StreetType streetType) {
		City nodeA = cityFactory.getCity(a);
		City nodeB = cityFactory.getCity(b);
		landscape.add(new Street(nodeA, nodeB, dist, streetType));
		landscape.add(new Street(nodeB, nodeA, dist, streetType));
	}

	protected void addOneDirectional(String a, String b, int dist, StreetType streetType) {
		City nodeA = cityFactory.getCity(a);
		City nodeB = cityFactory.getCity(b);
		landscape.add(new Street(nodeA, nodeB, dist, streetType));
	}

	Iterator<Street> getAll() {
		LOG.debug("getAll()");
		return landscape.iterator();
	}

	@PostConstruct
	public void postConstructInit() {
		LOG.debug("postConstructInit");
		addTwoDirectional("Bochum", "Essen", 20, StreetType.AUTOBAHN);
		addTwoDirectional("Essen", "Remscheid", 20, StreetType.AUTOBAHN);
		addTwoDirectional("Essen", "Düsseldorf", 30, StreetType.AUTOBAHN);
		addTwoDirectional("Düsseldorf", "Meerbusch", 10, StreetType.AUTOBAHN);
		addTwoDirectional("Düsseldorf", "Neuss", 10, StreetType.AUTOBAHN);
		addTwoDirectional("Düsseldorf", "Leverkusen", 10, StreetType.AUTOBAHN);
		addTwoDirectional("Düsseldorf", "Köln", 30, StreetType.AUTOBAHN);
		addTwoDirectional("Leverkusen", "Bonn", 10, StreetType.AUTOBAHN);
		addTwoDirectional("Bonn", "Siegburg", 10, StreetType.AUTOBAHN);
		addTwoDirectional("Wuppertal", "Essen", 20, StreetType.AUTOBAHN);
		addTwoDirectional("Wuppertal", "Leverkusen", 15, StreetType.AUTOBAHN);
		addTwoDirectional("Wuppertal", "Düsseldorf", 10, StreetType.AUTOBAHN);
		addTwoDirectional("Köln", "Koblenz", 100, StreetType.AUTOBAHN);
		addTwoDirectional("Köln", "Bonn", 40, StreetType.AUTOBAHN);
		addTwoDirectional("Aachen", "Köln", 100, StreetType.AUTOBAHN);
		addTwoDirectional("Aachen", "Neuss", 90, StreetType.AUTOBAHN);
		addTwoDirectional("Essen", "Duisburg", 30, StreetType.AUTOBAHN);

		addTwoDirectional("Bochum", "Essen", 15, StreetType.HIGHWAY);
		addTwoDirectional("Essen", "Remscheid", 15, StreetType.HIGHWAY);
		addTwoDirectional("Essen", "Düsseldorf", 20, StreetType.HIGHWAY);
		addTwoDirectional("Düsseldorf", "Meerbusch", 5, StreetType.HIGHWAY);
		addTwoDirectional("Düsseldorf", "Neuss", 5, StreetType.HIGHWAY);
		addTwoDirectional("Düsseldorf", "Leverkusen", 15, StreetType.HIGHWAY);
		addTwoDirectional("Düsseldorf", "Köln", 20, StreetType.HIGHWAY);
		addTwoDirectional("Leverkusen", "Bonn", 5, StreetType.HIGHWAY);
		addTwoDirectional("Bonn", "Siegburg", 10, StreetType.HIGHWAY);
		addTwoDirectional("Wuppertal", "Essen", 15, StreetType.HIGHWAY);
		addTwoDirectional("Wuppertal", "Leverkusen", 10, StreetType.HIGHWAY);
		addTwoDirectional("Wuppertal", "Düsseldorf", 10, StreetType.HIGHWAY);
		addTwoDirectional("Köln", "Koblenz", 80, StreetType.HIGHWAY);
		addTwoDirectional("Köln", "Bonn", 30, StreetType.HIGHWAY);
		addTwoDirectional("Aachen", "Köln", 80, StreetType.HIGHWAY);
		addTwoDirectional("Aachen", "Neuss", 80, StreetType.HIGHWAY);
		addTwoDirectional("Meerbusch", "Duisburg", 20, StreetType.HIGHWAY);

	}

	private double getFFunction(final City from, final City to) {
		double x = from.getX() - to.getX();
		double y = from.getY() - to.getY();
		return Math.hypot(x, y);
	}

	public Route getRoute(final String from, final String to, final VehicleType vehicleType) {
		LOG.debug("Route request from: " + from + " to " + to);

		// collect required data
		Route result = new Route(cityFactory.getCity(from), cityFactory.getCity(to), vehicleType);

		// test input values
		if (result.getFrom() == null)
			throw new CityNotFoundException("City " + from + " is unknown");
		if (result.getTo() == null)
			throw new CityNotFoundException("City " + to + " is unknown");

		// calculate f-function basing on the coordinates
		result.setBeeline(getFFunction(result.getFrom(), result.getTo()) * 20); // *10 cause the chosen coordinates
																				// creates to small values

		LOG.debug("getRoute: f-Value=" + result.getBeeline());

		// TODO: fill in
		return result;
	}

	public void printLandscape() {
		LOG.debug("printLandscape");
		Iterator<Street> it = landscape.iterator();
		while (it.hasNext()) {
			Street e = it.next();
			LOG.info(e.toString());
		}
	}

}
