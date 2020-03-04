package de.openaqua.ipsc.landscape;

import java.util.HashMap;
import java.util.Map;

public class CityFactory {
	private Map<String, City> nodeSet;
	private static final CityFactory instanceOfNodeFactory = new CityFactory();

	private CityFactory() {
		super();
		this.nodeSet = new HashMap<String, City>();

	}

	protected static CityFactory getInstance() {
		return instanceOfNodeFactory;
	}

	public static void addNode(City n) {
		instanceOfNodeFactory.nodeSet.put(n.getName(), n);
	}

	public static City getNode(final String key) {
		Map<String, City> map = instanceOfNodeFactory.nodeSet;
		if (map.containsKey(key)) {
			return map.get(key);
		} else {
			return null;
		}
	};

}
