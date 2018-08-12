package uk.co.bigredlobster.graph.search.cost.dijsktra;

import com.google.common.collect.Streams;
import uk.co.bigredlobster.graph.basicGridWithCost.GridGraphWithWallsAndCost;
import uk.co.bigredlobster.graph.search.cost.CostAndCameFrom;
import uk.co.bigredlobster.graph.search.cost.DrawGrid;
import uk.co.bigredlobster.graph.search.cost.GraphNodeWithCost;
import uk.co.bigredlobster.graph.search.cost.NodeCostComparator;
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

    public CostAndCameFrom search(final GraphNodeWithCost start, final GraphNodeWithCost goal) {
        final PriorityQueue<GraphNodeWithCost> frontier = new PriorityQueue<>(new NodeCostComparator());
        final Map<GraphNodeWithCost, GraphNodeWithCost> cameFrom = new HashMap<>();
        final Map<GraphNodeWithCost, NodeCost> costSoFar = new HashMap<>();

        frontier.add(start);
        cameFrom.put(start, start);
        costSoFar.put(start, NodeCost.ZERO);

        GraphNodeWithCost current;
        while (!frontier.isEmpty()) {
            current = frontier.remove();

            if (current.equals(goal))
                break;

            for (final GraphNode neighbour : graphWithWallsAndCost.graph.successors(current.graphNode)) {
                final GraphNodeWithCost neighbourWithCost = new GraphNodeWithCost(neighbour, graphWithWallsAndCost.graph.edgeValue(neighbour, current.graphNode).get());
                final NodeCost newCost = new NodeCost(costSoFar.get(current).value + neighbourWithCost.cost.value);

                boolean addIt = false;
                if (!costSoFar.containsKey(neighbourWithCost)) {
                    addIt = true;
                } else if (newCost.value < costSoFar.get(neighbourWithCost).value) {
                    addIt = true;
                }

                if (addIt) {
                    costSoFar.put(neighbourWithCost, newCost);
                    frontier.add(neighbourWithCost);
                    cameFrom.put(neighbourWithCost, current);
                }
            }
        }

        return new CostAndCameFrom(cameFrom, costSoFar);
    }

    public void drawGrid(final CostAndCameFrom search, final GraphNodeWithCost start,
                         final GraphNodeWithCost goal, final DrawStyle drawStyle) {
        DrawGrid.drawGrid(graphWithWallsAndCost, search, start, goal, drawStyle);
    }
}
