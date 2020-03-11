package de.openaqua.ipsc.landscape;

import org.jgrapht.Graph;
import org.jgrapht.alg.shortestpath.AStarShortestPath;

public class AStarShortestPathIntern extends AStarShortestPath<City, Street> {

	private VehicleType type=null;

	public AStarShortestPathIntern(Graph<City, Street> graph, VehicleType type) {
		super(graph, new AStarAdmissibleHeuristicCity());
		this.type = type;
	}

	@Override
	public double getPathWeight(City source, City sink) {
		// TODO Auto-generated method stub
		// Graph<City, Street> graph = (Graph<City, Street>) getPath(source, sink);
		// graph.getAllEdges(sourceVertex, targetVertex)
		double foo = super.getPathWeight(source, sink);
		/*
		 * switch(type) { case: VehicleType.BYCICLE;
		 * 
		 * case: VehicleType.BIKE; case: VehicleType.CAR; case: VehicleType.TRUCK; }
		 */
		return foo;
	}

	@Override
	public SingleSourcePaths<City, Street> getPaths(City source) {
		/*
		 * SingleSourcePaths<City, Street> pathsOrig = getPaths(source);
		 * SingleSourcePaths<City, Street> paths = new SingleSourcePaths<City,
		 * Street>(); paths. while switch(type) { case:: VehicleType.BIKE; case:
		 * VehicleType.BYCICLE; case: VehicleType.CAR; case: VehicleType.TRUCK; }
		 */
		return super.getPaths(source);
	}

}
