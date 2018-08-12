package uk.co.bigredlobster.graph.search.cost.aStar;

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

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SearchAStarWithPathAndEarlyExit {

    private final GridGraphWithWallsAndCost graphWithWallsAndCost;

    public SearchAStarWithPathAndEarlyExit(final GridGraphWithWallsAndCost graphWithWallsAndCost) {
        this.graphWithWallsAndCost = graphWithWallsAndCost;
    }

    private NodeCost heuristic(final GraphNode a, final GraphNode b) {
        final PositionX x1 = a.position.x;
        final PositionY y1 = a.position.y;

        final PositionX x2 = b.position.x;
        final PositionY y2 = b.position.y;

        final int value = Math.abs(x1.value - x2.value) + Math.abs(y1.value - y2.value);
        return new NodeCost(value);
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
                final GraphNodeWithCost neighbourWithCost = new GraphNodeWithCost(neighbour, graphWithWallsAndCost.graph.edgeValue(neighbour, current.graphNode).orElseThrow(RuntimeException::new));
                final NodeCost newCost = new NodeCost(costSoFar.get(current).value + neighbourWithCost.cost.value);

                boolean addIt = false;
                if (!costSoFar.containsKey(neighbourWithCost)) {
                    addIt = true;
                } else if (newCost.value <= costSoFar.get(neighbourWithCost).value) {
                    addIt = true;
                }

                if (addIt) {
                    costSoFar.put(neighbourWithCost, newCost);
                    cameFrom.put(neighbourWithCost, current);

                    final NodeCost newCostWithHeuristic = new NodeCost(newCost.value + heuristic(goal.graphNode, neighbour).value);
                    final GraphNodeWithCost priorityForFrontier = new GraphNodeWithCost(new GraphNode(neighbourWithCost.graphNode), new NodeCost(newCostWithHeuristic));
                    frontier.add(priorityForFrontier);
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
