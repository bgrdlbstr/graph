package uk.co.bigredlobster.graph;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import uk.co.bigredlobster.graph.nodes.IGraphNode;

import java.util.Objects;

public class GridGraph implements IGraph {
    final ImmutableMap<IGraphNode, ImmutableSet<IGraphNode>> edges;

    public GridGraph(final ImmutableMap<IGraphNode, ImmutableSet<IGraphNode>> edges) {
        this.edges = edges;
    }

    @Override
    public ImmutableMap<IGraphNode, ImmutableSet<IGraphNode>> edges() {
        return edges;
    }

    @Override
    public ImmutableSet<IGraphNode> neighbours(final IGraphNode current) {
        return edges.get(current);
    }

    @Override
    public String toString() {
        return "GridGraph{" +
                "edges=" + edges +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GridGraph that = (GridGraph) o;
        return Objects.equals(edges, that.edges);
    }

    @Override
    public int hashCode() {

        return Objects.hash(edges);
    }
}
