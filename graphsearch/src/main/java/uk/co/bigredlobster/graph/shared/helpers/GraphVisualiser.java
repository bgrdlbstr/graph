package uk.co.bigredlobster.graph.shared.helpers;

import uk.co.bigredlobster.graph.basicGridWithCost.GridGraphWithWallsAndCost;
import uk.co.bigredlobster.graph.basicGridWithWalls.GridGraphWithWalls;
import uk.co.bigredlobster.graph.search.cost.GraphNodeWithCost;
import uk.co.bigredlobster.graph.shared.node.GraphNode;
import uk.co.bigredlobster.graph.shared.node.GridPosition;
import uk.co.bigredlobster.microtypes.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class GraphVisualiser {
    public final int width;
    public final int height;
    public final List<WallPosition> walls;
    public final List<CostPosition> costs;

    public GraphVisualiser(int width, int height, final List<WallPosition> walls, final List<CostPosition> costs) {
        this.width = width;
        this.height = height;
        this.walls = walls;
        this.costs = costs;
    }

    public GraphVisualiser(int width, int height, final List<WallPosition> walls) {
        this.width = width;
        this.height = height;
        this.walls = walls;
        this.costs = new ArrayList<>();
    }

    public void drawGrid(GridGraphWithWalls graph) {
        drawIt(graph.graph.nodes());
    }

    public String drawTile(final GraphNode node, final Object data, final DrawStyle style) {
        if (walls.contains(new WallPosition(node.position.x, node.position.y)))
            return "#";

        switch (style) {
            case START:
                return "S";
            case GOAL:
                return "G";
            case NUMBERS:
                final HasVisitedAndWhen hasVisitedAndWhen = (HasVisitedAndWhen) data;
                return String.valueOf(hasVisitedAndWhen.when.value);
            case FROM:
                final GraphNode from = (GraphNode) data;
                if (node.position.x.value == from.position.x.value + 1)
                    return "<";
                else if (node.position.x.value == from.position.x.value - 1)
                    return ">";
                else if (node.position.y.value == from.position.y.value + 1)
                    return "^";
                else if (node.position.y.value == from.position.y.value - 1)
                    return "v";
            case RAW:
                return ".";
            case COST_SO_FAR:
                final GraphNodeWithCost cost = (GraphNodeWithCost) data;
                final String costString = getCostString(node);
                return cost.cost.value + costString;
            case PATH:
                return "X";
            default:
                throw new RuntimeException("Missing DrawStyle");
        }
    }

    private String getCostString(final GraphNode node) {
        String costStr = "";
        final CostPosition costPosition = costs.stream()
                .filter(z -> z.x.equals(node.position.x) && z.y.equals(node.position.y))
                .findFirst()
                .orElse(new CostPosition(node.position, NodeCost.ONE));
        if(!costPosition.cost.equals(NodeCost.ONE))
            costStr = costPosition.cost.value + "";
        return costStr;
    }

    public void drawGrid(GridGraphWithWallsAndCost graph) {
        drawIt(graph.graph.nodes());
    }

    private void drawIt(Set<GraphNode> nodes) {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                final int theX = x;
                final int theY = y;
                final GraphNode node = nodes.stream()
                        .filter(z -> z.position.equals(new GridPosition(new PositionX(theX), new PositionY(theY))))
                        .findFirst()
                        .orElseThrow(RuntimeException::new);
                System.out.print(drawTile(node, new Object(), DrawStyle.RAW));
            }
            System.out.println();
        }
    }
}
