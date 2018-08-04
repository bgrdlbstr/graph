package uk.co.bigredlobster.homegrownGraph.graphs;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import uk.co.bigredlobster.homegrownGraph.IGraph;
import uk.co.bigredlobster.homegrownGraph.nodes.IGraphNode;
import uk.co.bigredlobster.microtypes.WallPosition;

import java.util.List;

public class GraphFactory {
    public static IGraph getSimpleGraph(final ImmutableMap<IGraphNode, ImmutableSet<IGraphNode>> edges) {
        return new SimpleGraph(edges);
    }

    public static IGraph getGridGraph(final int width, final int height) {
        return new GridGraph.Builder(width, height).build();
    }

    public static IGraph getGridGraphWithWalls(final int width, final int height, final List<WallPosition> walls) {
        return new GridGraphWithWalls.Builder(width, height, walls).build();
    }
}
