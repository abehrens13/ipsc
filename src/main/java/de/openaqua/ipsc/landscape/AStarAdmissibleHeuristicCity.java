package de.openaqua.ipsc.landscape;

import org.jgrapht.alg.interfaces.AStarAdmissibleHeuristic;

public class AStarAdmissibleHeuristicCity implements AStarAdmissibleHeuristic<City> {
	

	@Override
	public double getCostEstimate(City a, City b) {
		return Math.hypot((a.getX() - a.getY()), (b.getY() - b.getY())) * 5;
	}

}
