package uk.co.bigredlobster.graph.search.breadthFirst;

import com.google.common.collect.Streams;
import uk.co.bigredlobster.graph.shared.helpers.DrawStyle;
import uk.co.bigredlobster.graph.basicGridWithWalls.GridGraphWithWalls;
import uk.co.bigredlobster.graph.shared.node.GraphNode;
import uk.co.bigredlobster.microtypes.PositionX;
import uk.co.bigredlobster.microtypes.PositionY;
import uk.co.bigredlobster.microtypes.WallPosition;

import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.stream.Collectors;

public class SearchBreadthFirstWithPathAndEarlyExit {

    private final GridGraphWithWalls simpleGraph;

    public SearchBreadthFirstWithPathAndEarlyExit(final GridGraphWithWalls simpleGraph) {
        this.simpleGraph = simpleGraph;
    }

    public Map<GraphNode, GraphNode> search(final GraphNode start, final GraphNode goal) {
        final Queue<GraphNode> frontier = new LinkedBlockingDeque<>();
        final Map<GraphNode, GraphNode> cameFrom = new HashMap<>();

        frontier.add(start);
        cameFrom.put(start, GraphNode.NOTHING);

        GraphNode current;
        while (!frontier.isEmpty()) {
            current = frontier.remove();

            if (current.equals(goal))
                break;

            for (final GraphNode neighbour : simpleGraph.graph.successors(current)) {
                if (!cameFrom.containsKey(neighbour)) {
                    frontier.add(neighbour);
                    cameFrom.put(neighbour, current);
                }
            }
        }

        return cameFrom;
    }

    public void drawGrid(final Map<GraphNode, GraphNode> search, final GraphNode start, final GraphNode goal) {
        final int height = simpleGraph.graphVisualiser.height;
        final int width = simpleGraph.graphVisualiser.width;
        final List<WallPosition> walls = simpleGraph.graphVisualiser.walls;

        String[][] grid = new String[height][width];

        search.forEach((node, from) ->
                grid[node.position.y.value][node.position.x.value] = simpleGraph.graphVisualiser.drawTile(node, from, DrawStyle.FROM)
        );

        final List<GraphNode> path = reconstructPath(search, start, goal);
        path.forEach(node ->
                grid[node.position.y.value][node.position.x.value] = simpleGraph.graphVisualiser.drawTile(node, new Object(), DrawStyle.PATH)
        );

        grid[start.position.y.value][start.position.x.value] = simpleGraph.graphVisualiser.drawTile(start, start, DrawStyle.START);
        grid[goal.position.y.value][goal.position.x.value] = simpleGraph.graphVisualiser.drawTile(goal, goal, DrawStyle.GOAL);

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

    public List<GraphNode> reconstructPath(final Map<GraphNode, GraphNode> cameFrom, final GraphNode start, final GraphNode goal) {
        final Deque<GraphNode> path = new ArrayDeque<>();
        GraphNode current = goal;
        while (!current.equals(start)) {
            path.add(current);
            current = cameFrom.get(current);
        }
        path.add(start);

        return Streams.stream(path.descendingIterator()).collect(Collectors.toList());
    }
}
