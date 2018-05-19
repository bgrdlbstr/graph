package uk.co.bigredlobster.graph.searchAlgos;

import uk.co.bigredlobster.graph.SimpleGraph;
import uk.co.bigredlobster.graph.SimpleGraphBuilder;
import uk.co.bigredlobster.graph.nodes.GraphNode;
import uk.co.bigredlobster.microtypes.HasVisited;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

public class GraphSearchBreadthFirst implements IGraphSearch {

    private final SimpleGraph simpleGraph;

    private GraphSearchBreadthFirst(SimpleGraph simpleGraph) {
        this.simpleGraph = simpleGraph;
    }

    @Override
    public Map<GraphNode, HasVisited> search(final GraphNode start) {
        final Queue<GraphNode> frontier = new LinkedBlockingDeque<>();
        final Map<GraphNode, HasVisited> visited = new HashMap<>();

        frontier.add(start);
        visited.put(start, new HasVisited(true));

        GraphNode current;
        while (!frontier.isEmpty()) {
            current = frontier.remove();
            System.out.println("Visiting node " + current);
            for (final GraphNode neighbour : simpleGraph.neighbours(current)) {
                if (!visited.containsKey(neighbour)) {
                    frontier.add(neighbour);
                    visited.put(neighbour, new HasVisited(true));
                }
            }

        }

        return visited;
    }

    public static void main(String[] args) {
        final SimpleGraph simpleGraph = new SimpleGraphBuilder().build();
        final IGraphSearch graphSearch = new GraphSearchBreadthFirst(simpleGraph);
        graphSearch.search(simpleGraph.edges.get(new GraphNode("04")).asList().get(0));
    }
}
