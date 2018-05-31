package uk.co.bigredlobster.graph;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import uk.co.bigredlobster.graph.nodes.IGraphNode;

import java.util.Objects;

public class SimpleGraph {
    public final ImmutableMap<IGraphNode, ImmutableSet<IGraphNode>> edges;

    SimpleGraph(final ImmutableMap<IGraphNode, ImmutableSet<IGraphNode>> edges) {
        this.edges = edges;
    }

    public ImmutableSet<IGraphNode> neighbours(final IGraphNode current) {
        return edges.get(current);
    }

    public IGraphNode getEdge(final IGraphNode current) {
        return edges.get(current).asList().get(0);
    }

    @Override
    public String toString() {
        return "SimpleGraph{" +
                "edges=" + edges +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SimpleGraph that = (SimpleGraph) o;
        return Objects.equals(edges, that.edges);
    }

    @Override
    public int hashCode() {

        return Objects.hash(edges);
    }
}
