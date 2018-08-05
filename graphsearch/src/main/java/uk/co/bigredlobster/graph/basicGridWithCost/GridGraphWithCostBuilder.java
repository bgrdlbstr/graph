package uk.co.bigredlobster.graph.basicGridWithCost;

import com.google.common.collect.ImmutableMap;
import com.google.common.graph.ImmutableValueGraph;
import com.google.common.graph.MutableValueGraph;
import com.google.common.graph.ValueGraph;
import com.google.common.graph.ValueGraphBuilder;
import uk.co.bigredlobster.graph.shared.node.GraphNode;
import uk.co.bigredlobster.graph.shared.node.GridPosition;
import uk.co.bigredlobster.microtypes.*;

import java.util.List;

class GridGraphWithCostBuilder {
    private final int width;
    private final int height;
    private final MutableValueGraph<GraphNode, NodeCost> graph;
    private final ImmutableMap<GridPosition, GraphNode> nodes;
    private final List<WallPosition> walls;
    private final List<CostPosition> costs;

    public GridGraphWithCostBuilder(final int width, final int height, final List<WallPosition> walls, final List<CostPosition> costs) {
        this.width = width;
        this.height = height;
        this.walls = walls;
        this.costs = costs;
        graph = ValueGraphBuilder.directed().allowsSelfLoops(false).expectedNodeCount(width * height).build();
        nodes = makeNodes();
    }

    ValueGraph<GraphNode, NodeCost> build() {
        addEdges();
        return ImmutableValueGraph.copyOf(graph);
    }

    private ImmutableMap<GridPosition, GraphNode> makeNodes() {
        ImmutableMap.Builder<GridPosition, GraphNode> builder = ImmutableMap.builder();
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                final GridPosition position = new GridPosition(new PositionX(x), new PositionY(y));
                builder.put(position, new GraphNode(position));
            }
        }
        return builder.build();
    }

    private void addEdges() {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                addNorth(x, y);
                addEast(x, y);
                addSouth(x, y);
                addWest(x, y);
            }
        }
    }

    private void addWest(int x, int y) {
        final GridPosition current = new GridPosition(new PositionX(x), new PositionY(y));
        final GridPosition edgeTo = new GridPosition(new PositionX(x - 1), new PositionY(y));
        addEdge(current, edgeTo);
    }

    private void addSouth(int x, int y) {
        final GridPosition current = new GridPosition(new PositionX(x), new PositionY(y));
        final GridPosition edgeTo = new GridPosition(new PositionX(x), new PositionY(y - 1));
        addEdge(current, edgeTo);
    }

    private void addEast(int x, int y) {
        final GridPosition current = new GridPosition(new PositionX(x), new PositionY(y));
        final GridPosition edgeTo = new GridPosition(new PositionX(x + 1), new PositionY(y));
        addEdge(current, edgeTo);
    }

    private void addNorth(int x, int y) {
        final GridPosition current = new GridPosition(new PositionX(x), new PositionY(y));
        final GridPosition edgeTo = new GridPosition(new PositionX(x), new PositionY(y + 1));
        addEdge(current, edgeTo);
    }

    private void addEdge(final GridPosition current, final GridPosition edgeTo) {
        if (inBounds(edgeTo)) {
            if (!walls.contains(new WallPosition(edgeTo.x, edgeTo.y))) {
                final CostPosition nodeCost = costs.stream()
                        .filter(cost -> cost.x.equals(edgeTo.x) && cost.y.equals(edgeTo.y))
                        .findFirst()
                        .orElse(new CostPosition(edgeTo.x, edgeTo.y, new NodeCost(1)));
                graph.putEdgeValue(
                        nodes.get(current),
                        nodes.get(edgeTo),
                        nodeCost.cost
                );
            }
        }
    }

    private boolean inBounds(final GridPosition toCheck) {
        return toCheck.x.value >= 0 && toCheck.x.value < width && toCheck.y.value >= 0 && toCheck.y.value < height;
    }
}
