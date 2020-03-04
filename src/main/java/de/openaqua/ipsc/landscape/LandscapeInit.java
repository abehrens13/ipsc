package de.openaqua.ipsc.landscape;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class LandscapeInit {
	private static final Log LOG = LogFactory.getLog(LandscapeInit.class);

	public LandscapeInit() {
		super();
	}

	private void initGermanyCities() {
		NodeFactory.addNode(new City("Düsseldorf", 0, 0));
	}

	public void initGermany(Landscape ls) {
		LOG.debug("initGermany()");
		initGermanyCities();

		/*
		 * addTwoDirectional("Düsseldorf", "Neuss", 10); addTwoDirectional("Düsseldorf",
		 * "Meerbusch", 10); addTwoDirectional("Düsseldorf", "Dortmund", 50);
		 * addTwoDirectional("Neuss", "Köln", 40); addTwoDirectional("Köln",
		 * "Leverkusen", 40); addTwoDirectional("Leverkusen", "Bonn", 35);
		 * addTwoDirectional("Leverkusen", "Düsseldorf", 35);
		 * addTwoDirectional("Leverkusen", "Essen", 35); addTwoDirectional("Düsseldorf",
		 * "Essen", 40); addTwoDirectional("Meerbusch", "Essen", 30);
		 * addTwoDirectional("Düsseldorf", "Remscheid", 40);
		 * addTwoDirectional("Düsseldorf", "Bonn", 70); addTwoDirectional("Neuss",
		 * "Meerbusch", 70);
		 */
	}

}
