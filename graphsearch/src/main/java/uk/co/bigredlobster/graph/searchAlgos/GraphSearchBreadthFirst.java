package uk.co.bigredlobster.graph.searchAlgos;

import uk.co.bigredlobster.graph.GridGraphBuilder;
import uk.co.bigredlobster.graph.SimpleGraph;
import uk.co.bigredlobster.graph.SimpleGraphBuilder;
import uk.co.bigredlobster.graph.nodes.GraphNode;
import uk.co.bigredlobster.graph.nodes.GridGraphNode;
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

    public static void main(String[] args) {
        final SimpleGraph simpleGraph = new SimpleGraphBuilder().build();
        final IGraphSearch graphSearch = new GraphSearchBreadthFirst(simpleGraph);
        graphSearch.search(simpleGraph.edges.get(new GraphNode("4")).asList().get(0));

        final SimpleGraph simpleGraph2 = new GridGraphBuilder(50, 10).build();
        final IGraphSearch graphSearch2 = new GraphSearchBreadthFirst(simpleGraph2);

        final IGraphNode graphNode7 = new GridGraphNode(new GraphNode("7"));
        graphSearch2.search(simpleGraph2.edges.get(graphNode7).asList().get(0));

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
