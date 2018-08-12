package uk.co.bigredlobster.graph.search.cost;

import com.google.common.collect.Streams;
import uk.co.bigredlobster.graph.basicGridWithCost.GridGraphWithWallsAndCost;
import uk.co.bigredlobster.graph.shared.helpers.DrawStyle;
import uk.co.bigredlobster.microtypes.*;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.stream.Collectors;

public class DrawGrid {

    public static void drawGrid(final GridGraphWithWallsAndCost graphWithWallsAndCost,
                                final CostAndCameFrom search,
                                final GraphNodeWithCost start,
                                final GraphNodeWithCost goal,
                                final DrawStyle drawStyle) {

        final int height = graphWithWallsAndCost.graphVisualiser.height;
        final int width = graphWithWallsAndCost.graphVisualiser.width;
        final List<WallPosition> walls = graphWithWallsAndCost.graphVisualiser.walls;
        final List<CostPosition> costs = graphWithWallsAndCost.graphVisualiser.costs;

        String[][] grid = new String[height][width];

        search.cameFrom.forEach((n, from) ->
                grid[n.graphNode.position.y.value][n.graphNode.position.x.value] = graphWithWallsAndCost.graphVisualiser.drawTile(n.graphNode, from, DrawStyle.RAW)
        );

        final List<GraphNodeWithCost> path = reconstructPath(search, start, goal);
        path.forEach(n ->
                grid[n.graphNode.position.y.value][n.graphNode.position.x.value] = graphWithWallsAndCost.graphVisualiser.drawTile(n.graphNode, n, drawStyle)
        );

        grid[start.graphNode.position.y.value][start.graphNode.position.x.value] = graphWithWallsAndCost.graphVisualiser.drawTile(start.graphNode, start.graphNode, DrawStyle.START);
        grid[goal.graphNode.position.y.value][goal.graphNode.position.x.value] = graphWithWallsAndCost.graphVisualiser.drawTile(goal.graphNode, goal.graphNode, DrawStyle.GOAL);

        StringBuilder sb = new StringBuilder();
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (walls.contains(new WallPosition(new PositionX(x), new PositionY(y))))
                    sb.append("  ###");
                else if (costs.contains(new CostPosition(new PositionX(x), new PositionY(y), NodeCost.EMPTY)))
                    sb.append(
                            String.format("%4s", "(" + costs.stream().filter(z -> z.equals(new CostPosition(new PositionX(z.x), new PositionY(z.y), NodeCost.EMPTY))).findFirst().get().cost.value) + ")"
                    );
                else
                    sb.append(String.format("%5s", grid[y][x]));
            }
            sb.append(System.lineSeparator());
        }

        System.out.println(sb.toString());
    }

    private static List<GraphNodeWithCost> reconstructPath(final CostAndCameFrom costAndCameFrom,
                                                           final GraphNodeWithCost start, final GraphNodeWithCost goal) {
        final Deque<GraphNodeWithCost> path = new ArrayDeque<>();
        GraphNodeWithCost current = goal;
        while (!current.equals(start)) {
            path.add(new GraphNodeWithCost(current.graphNode, costAndCameFrom.costSoFar.get(current)));
            current = costAndCameFrom.cameFrom.get(current);
        }
        path.add(start);

        return Streams.stream(path.descendingIterator()).collect(Collectors.toList());
    }
}
