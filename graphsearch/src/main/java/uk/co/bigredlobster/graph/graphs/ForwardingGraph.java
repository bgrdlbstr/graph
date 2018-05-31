package uk.co.bigredlobster.graph.graphs;

import com.google.common.collect.ForwardingObject;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import uk.co.bigredlobster.graph.IGraph;
import uk.co.bigredlobster.graph.nodes.IGraphNode;

import static com.google.common.base.Preconditions.checkNotNull;

public class ForwardingGraph extends ForwardingObject implements IGraph {

    private final IGraph graph;

    ForwardingGraph(final IGraph graph) {
        this.graph = checkNotNull(graph);
    }

    @Override
    protected Object delegate() {
        return graph;
    }

    @Override
    public ImmutableSet<IGraphNode> neighbours(IGraphNode current) {
        return graph.neighbours(current);
    }

    @Override
    public ImmutableMap<IGraphNode, ImmutableSet<IGraphNode>> edges() {
        return graph.edges();
    }
}
