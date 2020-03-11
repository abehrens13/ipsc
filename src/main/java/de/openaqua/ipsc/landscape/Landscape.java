package de.openaqua.ipsc.landscape;

import java.util.Iterator;

import javax.annotation.PostConstruct;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jgrapht.Graph;
import org.jgrapht.GraphPath;
import org.jgrapht.alg.shortestpath.AStarShortestPath;
import org.jgrapht.graph.DirectedWeightedPseudograph;
import org.springframework.beans.factory.annotation.Autowired;

public class Landscape {

	// stores a collection of Streets between Cities.
	Graph<City, Street> landscape = new DirectedWeightedPseudograph<City, Street>(Street.class);

	@Autowired
	CityFactory cityFactory;

	// Between two cities there could be more than one street.
	private static final Log LOG = LogFactory.getLog(Landscape.class);

	public Landscape() {
		super();
	}

	protected void addStreet(City a, City b, Street s) {
		landscape.addEdge(a, b, s);
	}

	protected void addTwoDirectional(String a, String b, int dist, StreetType streetType) {
		City nodeA = cityFactory.getCity(a);
		City nodeB = cityFactory.getCity(b);
		if (nodeA == null)
			throw new CityNotFoundException(a);
		if (nodeB == null)
			throw new CityNotFoundException(b);
		addStreet(nodeA, nodeB, new Street(nodeA, nodeB, dist, streetType));
		addStreet(nodeB, nodeA, new Street(nodeB, nodeA, dist, streetType));
	}

	protected void addOneDirectional(String a, String b, int dist, StreetType streetType) {
		City nodeA = cityFactory.getCity(a);
		City nodeB = cityFactory.getCity(b);
		if (nodeA == null)
			throw new CityNotFoundException(a);
		if (nodeB == null)
			throw new CityNotFoundException(b);
		addStreet(nodeA, nodeB, new Street(nodeA, nodeB, dist, streetType));
	}

	public Iterator<Street> getAll() {
		LOG.debug("getAll()");
		return landscape.edgeSet().iterator();
	}

	public Iterator<Street> getAllStreets() {
		LOG.debug("getAllStreets()");
		return landscape.edgeSet().iterator();
	}

	@PostConstruct
	public void postConstructInit() {
		LOG.debug("postConstructInit");

		// Add all Cities to the landscape
		cityFactory.addCity(new City("Duisburg", 3, 4));
		cityFactory.addCity(new City("Bochum", 4, 1));
		cityFactory.addCity(new City("Essen", 4, 2));
		cityFactory.addCity(new City("Remscheid", 5, 3));
		cityFactory.addCity(new City("Meerbusch", 3, 5));
		cityFactory.addCity(new City("Siegburg", 6, 5));
		cityFactory.addCity(new City("Düsseldorf", 4, 6));
		cityFactory.addCity(new City("Leverkusen", 6, 6));
		cityFactory.addCity(new City("Bonn", 8, 6));
		cityFactory.addCity(new City("Neuss", 3, 7));
		cityFactory.addCity(new City("Koblenz", 6, 11));
		cityFactory.addCity(new City("Aachen", 1, 9));
		cityFactory.addCity(new City("Wuppertal", 5, 4));
		cityFactory.addCity(new City("Köln", 8, 4));
		Iterator<City> it = cityFactory.getCities();
		while (it.hasNext())
			landscape.addVertex(it.next());

		// add all known streets to the landscape
		addTwoDirectional("Bochum", "Essen", 20, StreetType.AUTOBAHN);
		addTwoDirectional("Essen", "Remscheid", 20, StreetType.AUTOBAHN);
		addTwoDirectional("Essen", "Düsseldorf", 30, StreetType.AUTOBAHN);
		addTwoDirectional("Düsseldorf", "Neuss", 10, StreetType.AUTOBAHN);
		addTwoDirectional("Düsseldorf", "Leverkusen", 10, StreetType.AUTOBAHN);
		addTwoDirectional("Düsseldorf", "Köln", 35, StreetType.AUTOBAHN);
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

	public Route getRoute(final String from, final String to, final VehicleType vehicleType) {
		LOG.debug("Route request from: " + from + " to " + to);

		// collect required data
		Route result = new Route(cityFactory.getCity(from), cityFactory.getCity(to), vehicleType);

		// test input values
		if (result.getFrom() == null)
			throw new CityNotFoundException("City " + from + " is unknown");
		if (result.getTo() == null)
			throw new CityNotFoundException("City " + to + " is unknown");

		// calculate and store the distance
		AStarShortestPath<City, Street> router = new AStarShortestPathIntern(landscape, vehicleType);
		GraphPath<City, Street> path = router.getPath(result.getFrom(), result.getTo());
		result.setRoute(path.getEdgeList()); // stores the distance to.

		return result;
	}
}
