package uk.co.bigredlobster.graph.nodes;

import com.google.common.collect.Sets;

import java.util.Arrays;
import java.util.Objects;
import java.util.Set;

public class GraphNode {

    private final Set<GraphNode> neighbours;
    private final String name;

    public GraphNode(final String name, final GraphNode... neighbours) {
        this.name = name;
        this.neighbours = Sets.newHashSet(neighbours);
    }

    @Override
    public String toString() {
        return "GraphNode{" +
                "name=" + name +
                ", neighbours=" + Arrays.toString(neighbours.toArray()) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GraphNode graphNode = (GraphNode) o;
        return Objects.equals(neighbours, graphNode.neighbours) &&
                Objects.equals(name, graphNode.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(neighbours, name);
    }
}
