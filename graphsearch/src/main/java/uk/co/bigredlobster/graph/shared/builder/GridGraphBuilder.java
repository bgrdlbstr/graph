package uk.co.bigredlobster.graph.shared.builder;

import com.google.common.collect.ImmutableMap;
import com.google.common.graph.GraphBuilder;
import com.google.common.graph.ImmutableGraph;
import com.google.common.graph.MutableGraph;
import uk.co.bigredlobster.graph.shared.node.GraphNode;
import uk.co.bigredlobster.graph.shared.node.GridPosition;
import uk.co.bigredlobster.microtypes.PositionX;
import uk.co.bigredlobster.microtypes.PositionY;
import uk.co.bigredlobster.microtypes.WallPosition;

import java.util.ArrayList;
import java.util.List;

public class GridGraphBuilder {
    private final int width;
    private final int height;
    private final MutableGraph<GraphNode> graph;
    private final ImmutableMap<GridPosition, GraphNode> nodes;
    private List<WallPosition> walls;

    public GridGraphBuilder(final int width, final int height) {
        this(width, height, new ArrayList<>());
    }

    public GridGraphBuilder(final int width, final int height, final List<WallPosition> walls) {
        this.width = width;
        this.height = height;
        this.walls = walls;
        graph = GraphBuilder.directed().allowsSelfLoops(false).expectedNodeCount(width * height).build();
        nodes = makeNodes();
    }

    public ImmutableGraph<GraphNode> build() {
        addEdges();
        return ImmutableGraph.copyOf(graph);
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
                graph.putEdge(
                        nodes.get(current),
                        nodes.get(edgeTo)
                );
            }
        }
    }

    private boolean inBounds(final GridPosition toCheck) {
        return toCheck.x.value >= 0 && toCheck.x.value < width && toCheck.y.value >= 0 && toCheck.y.value < height;
    }
}
