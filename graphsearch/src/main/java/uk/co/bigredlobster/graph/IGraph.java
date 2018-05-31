package uk.co.bigredlobster.graph;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import uk.co.bigredlobster.graph.nodes.IGraphNode;

public interface IGraph {
    ImmutableSet<IGraphNode> neighbours(IGraphNode current);

    ImmutableMap<IGraphNode, ImmutableSet<IGraphNode>> edges();
}
