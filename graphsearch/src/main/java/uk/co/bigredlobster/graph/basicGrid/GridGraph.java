package uk.co.bigredlobster.graph.basicGrid;


import com.google.common.graph.MutableGraph;
import uk.co.bigredlobster.graph.shared.builder.GridGraphBuilder;
import uk.co.bigredlobster.graph.shared.helpers.GraphVisualiser;
import uk.co.bigredlobster.graph.shared.node.GraphNode;
import uk.co.bigredlobster.microtypes.WallPosition;

import java.util.ArrayList;
import java.util.List;

public class GridGraph {
    public final MutableGraph<GraphNode> graph;
    public final GraphVisualiser graphVisualiser;

    public GridGraph(final int width, final int height) {
        this.graph = new GridGraphBuilder(width, height).build();
        this.graphVisualiser = new GraphVisualiser(width, height, new ArrayList<>());
    }

    public GridGraph(final int width, final int height, final List<WallPosition> walls) {
        this.graph = new GridGraphBuilder(width, height, walls).build();
        this.graphVisualiser = new GraphVisualiser(width, height, walls);
    }

}
