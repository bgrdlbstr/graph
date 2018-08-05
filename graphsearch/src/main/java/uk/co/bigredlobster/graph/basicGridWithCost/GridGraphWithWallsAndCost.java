package uk.co.bigredlobster.graph.basicGridWithCost;


import com.google.common.graph.ValueGraph;
import uk.co.bigredlobster.graph.shared.helpers.GraphVisualiser;
import uk.co.bigredlobster.graph.shared.node.GraphNode;
import uk.co.bigredlobster.microtypes.NodeCost;
import uk.co.bigredlobster.microtypes.WallPosition;

import java.util.List;

public class GridGraphWithWallsAndCost {
    public final ValueGraph<GraphNode, NodeCost> graph;
    public final GraphVisualiser graphVisualiser;

    public GridGraphWithWallsAndCost(final int width, final int height, final List<WallPosition> walls) {
        this.graph = new GridGraphWithCostBuilder(width, height, walls).build();
        this.graphVisualiser = new GraphVisualiser(width, height, walls);
    }

}