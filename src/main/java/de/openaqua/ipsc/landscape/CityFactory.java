package de.openaqua.ipsc.landscape;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class CityFactory {
	private Map<String, City> nodeSet;
	private static final Log LOG = LogFactory.getLog(CityFactory.class);

	public CityFactory() {
		super();
		this.nodeSet = new HashMap<String, City>();

	}

	public void addCity(City n) {
		if (!nodeSet.containsKey(n.getName())) {
			nodeSet.put(n.getName(), n);
		}
	}

	public Iterator<City> getCities() {
		return nodeSet.values().iterator();
	}

	/**
	 * 
	 * Returnsa prestored City 
	 * 
	 * @param cityName
	 * @return null if city not found otherwise a City object
	 */
	public City getCity(final String cityName) {
		if (nodeSet.containsKey(cityName)) {
			return nodeSet.get(cityName);
		} else {
			return null;
		}
	};

	@PostConstruct
	public void postConstructInit() {
		LOG.debug("postConstructInit");

		addCity(new City("Duisburg", 3, 4));
		addCity(new City("Bochum", 4, 1));
		addCity(new City("Essen", 4, 2));
		addCity(new City("Remscheid", 5, 3));
		addCity(new City("Meerbusch", 3, 5));
		addCity(new City("Siegburg", 6, 5));
		addCity(new City("Düsseldorf", 4, 6));
		addCity(new City("Leverkusen", 6, 6));
		addCity(new City("Bonn", 8, 6));
		addCity(new City("Neuss", 3, 7));
		addCity(new City("Koblenz", 6, 11));
		addCity(new City("Aachen", 1, 9));
		addCity(new City("Wuppertal", 5, 4));
	}

}
