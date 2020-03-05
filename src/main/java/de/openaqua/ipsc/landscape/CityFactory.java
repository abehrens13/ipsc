package de.openaqua.ipsc.landscape;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class CityFactory {
	private Map<String, City> nodeSet;

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

}
