package uk.co.bigredlobster.graph.search.cost;

import com.google.common.collect.Streams;
import uk.co.bigredlobster.graph.basicGridWithCost.GridGraphWithWallsAndCost;
import uk.co.bigredlobster.graph.shared.helpers.DrawStyle;
import uk.co.bigredlobster.graph.shared.node.GraphNode;
import uk.co.bigredlobster.microtypes.NodeCost;
import uk.co.bigredlobster.microtypes.PositionX;
import uk.co.bigredlobster.microtypes.PositionY;
import uk.co.bigredlobster.microtypes.WallPosition;

import java.util.*;
import java.util.stream.Collectors;

public class SearchUniformCostWithPathAndEarlyExit {

    private final GridGraphWithWallsAndCost graphWithWallsAndCost;

    public SearchUniformCostWithPathAndEarlyExit(final GridGraphWithWallsAndCost graphWithWallsAndCost) {
        this.graphWithWallsAndCost = graphWithWallsAndCost;
    }

    public Map<GraphNode, GraphNode> search(final GraphNode start, final GraphNode goal) {
        final PriorityQueue<GraphNode> frontier = new PriorityQueue<>(new GraphNodeWithCostComparator());
        final Map<GraphNode, GraphNode> cameFrom = new HashMap<>();

        frontier.add(start);
        cameFrom.put(start, NodeCost.EMPTY);

        GraphNode current;
        while (!frontier.isEmpty()) {
            current = frontier.remove();

            if (current.equals(goal))
                break;

            for (final GraphNode neighbour : graphWithWallsAndCost.graph.successors(current)) {
                if (!cameFrom.containsKey(neighbour)) {
                    frontier.add(neighbour);
                    cameFrom.put(neighbour, current);
                }
            }
        }

        return cameFrom;
    }

    public void drawGrid(final Map<GraphNode, GraphNode> search, final GraphNode start, final GraphNode goal) {
        final int height = graphWithWallsAndCost.graphVisualiser.height;
        final int width = graphWithWallsAndCost.graphVisualiser.width;
        final List<WallPosition> walls = graphWithWallsAndCost.graphVisualiser.walls;

        String[][] grid = new String[height][width];

        search.forEach((n, from) ->
                grid[n.position.y.value][n.position.x.value] = graphWithWallsAndCost.graphVisualiser.drawTile(n, from, DrawStyle.FROM)
        );

        final List<GraphNode> path = reconstructPath(search, start, goal);
        path.forEach(n ->
                grid[n.position.y.value][n.position.x.value] = graphWithWallsAndCost.graphVisualiser.drawTile(n, new Object(), DrawStyle.PATH)
        );

        grid[start.position.y.value][start.position.x.value] = graphWithWallsAndCost.graphVisualiser.drawTile(start, start, DrawStyle.START);
        grid[goal.position.y.value][goal.position.x.value] = graphWithWallsAndCost.graphVisualiser.drawTile(goal, goal, DrawStyle.GOAL);

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
