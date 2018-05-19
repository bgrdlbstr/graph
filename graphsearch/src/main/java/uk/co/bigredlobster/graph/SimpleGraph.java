package uk.co.bigredlobster.graph;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import uk.co.bigredlobster.graph.nodes.GraphNode;

import java.util.Objects;

public class SimpleGraph {
    public final ImmutableMap<GraphNode, ImmutableSet<GraphNode>> edges;

    SimpleGraph(final ImmutableMap<GraphNode, ImmutableSet<GraphNode>> edges) {
        this.edges = edges;
    }

    public ImmutableSet<GraphNode> neighbours(final GraphNode current) {
        return edges.get(current);
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
