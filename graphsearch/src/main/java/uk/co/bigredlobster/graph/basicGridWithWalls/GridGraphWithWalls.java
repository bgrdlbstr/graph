package uk.co.bigredlobster.graph.basicGridWithWalls;


import com.google.common.graph.ImmutableGraph;
import uk.co.bigredlobster.graph.shared.builder.GridGraphBuilder;
import uk.co.bigredlobster.graph.shared.helpers.GraphVisualiser;
import uk.co.bigredlobster.graph.shared.node.GraphNode;
import uk.co.bigredlobster.microtypes.WallPosition;

import java.util.List;

public class GridGraphWithWalls {
    public final ImmutableGraph<GraphNode> graph;
    public final GraphVisualiser graphVisualiser;

    public GridGraphWithWalls(final int width, final int height, final List<WallPosition> walls) {
        this.graph = new GridGraphBuilder(width, height, walls).build();
        this.graphVisualiser = new GraphVisualiser(width, height, walls);
    }

}
