package uk.co.bigredlobster.graph.searchAlgos;

import uk.co.bigredlobster.graph.SimpleGraph;
import uk.co.bigredlobster.graph.nodes.IGraphNode;
import uk.co.bigredlobster.microtypes.HasVisited;
import uk.co.bigredlobster.microtypes.HasVisitedAndWhen;
import uk.co.bigredlobster.microtypes.WhenVisited;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

public class GraphSearchBreadthFirst implements IGraphSearch {

    private final SimpleGraph simpleGraph;

    public GraphSearchBreadthFirst(SimpleGraph simpleGraph) {
        this.simpleGraph = simpleGraph;
    }

    @Override
    public Map<IGraphNode, HasVisitedAndWhen> search(final IGraphNode start) {
        final Queue<IGraphNode> frontier = new LinkedBlockingDeque<>();
        final Map<IGraphNode, HasVisitedAndWhen> visited = new HashMap<>();
        int numberOfNodesVisited = 0;

        frontier.add(start);
        visited.put(start, new HasVisitedAndWhen(new HasVisited(true), new WhenVisited(++numberOfNodesVisited)));

        IGraphNode current;
        while (!frontier.isEmpty()) {
            current = frontier.remove();
            System.out.println("Visiting node " + current);
            for (final IGraphNode neighbour : simpleGraph.neighbours(current)) {
                if (!visited.containsKey(neighbour)) {
                    frontier.add(neighbour);
                    visited.put(neighbour, new HasVisitedAndWhen(new HasVisited(true), new WhenVisited(++numberOfNodesVisited)));
                    System.out.println("  Added neighbour to visited list at visited number = " + numberOfNodesVisited + " neighbour = " + neighbour);
                }
            }
        }

        return visited;
    }
}
