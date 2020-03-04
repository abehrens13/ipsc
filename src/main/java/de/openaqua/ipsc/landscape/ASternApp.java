package de.openaqua.ipsc.landscape;

public class ASternApp {

	public static void main(String[] args) {
		Landscape ls = new Landscape();
		LandscapeInit init = new LandscapeInit();
		init.initGermany(ls);
	}
}
