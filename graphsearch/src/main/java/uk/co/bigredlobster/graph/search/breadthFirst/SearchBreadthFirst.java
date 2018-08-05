package uk.co.bigredlobster.graph.search.breadthFirst;

import uk.co.bigredlobster.graph.shared.helpers.DrawStyle;
import uk.co.bigredlobster.graph.basicGridWithWalls.GridGraphWithWalls;
import uk.co.bigredlobster.graph.shared.node.GraphNode;
import uk.co.bigredlobster.microtypes.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

public class SearchBreadthFirst {

    private final GridGraphWithWalls simpleGraph;

    public SearchBreadthFirst(final GridGraphWithWalls simpleGraph) {
        this.simpleGraph = simpleGraph;
    }

    public Map<GraphNode, HasVisitedAndWhen> search(final GraphNode start) {
        final Queue<GraphNode> frontier = new LinkedBlockingDeque<>();
        final Map<GraphNode, HasVisitedAndWhen> visited = new HashMap<>();
        int numberOfNodesVisited = 0;

        frontier.add(start);
        visited.put(start, new HasVisitedAndWhen(new HasVisited(true), new WhenVisited(++numberOfNodesVisited)));

        GraphNode current;
        while (!frontier.isEmpty()) {
            current = frontier.remove();
            for (final GraphNode neighbour : simpleGraph.graph.successors(current)) {
                if (!visited.containsKey(neighbour)) {
                    frontier.add(neighbour);
                    visited.put(neighbour, new HasVisitedAndWhen(new HasVisited(true), new WhenVisited(++numberOfNodesVisited)));
                }
            }
        }

        return visited;
    }

    public void drawGrid(Map<GraphNode, HasVisitedAndWhen> search) {
        final int height = simpleGraph.graphVisualiser.height;
        final int width = simpleGraph.graphVisualiser.width;
        final List<WallPosition> walls = simpleGraph.graphVisualiser.walls;

        String[][] grid = new String[height][width];

        search.forEach((node, hasVisitedAndWhen) ->
                grid[node.position.y.value][node.position.x.value] = simpleGraph.graphVisualiser.drawTile(node, hasVisitedAndWhen, DrawStyle.NUMBERS)
        );

        StringBuilder sb = new StringBuilder();
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (walls.contains(new WallPosition(new PositionX(x), new PositionY(y))))
                    sb.append("  ###");
                else
                    sb.append(String.format("%5s", grid[y][x]));
            }
            sb.append(System.lineSeparator());
        }

        System.out.println(sb.toString());
    }
}
