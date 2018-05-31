package uk.co.bigredlobster.graph.nodes.basic;

import com.google.common.collect.ImmutableSet;
import uk.co.bigredlobster.graph.nodes.IGraphNode;
import uk.co.bigredlobster.microtypes.NodeName;

import java.util.Arrays;
import java.util.Objects;
import java.util.Set;

public class GraphNode implements IGraphNode {

    private final ImmutableSet<IGraphNode> neighbours;
    private final NodeName name;

    public GraphNode(final NodeName name, final IGraphNode... neighbours) {
        this.name = name;
        this.neighbours = ImmutableSet.copyOf(neighbours);
    }

    @Override
    public Set<IGraphNode> getNeighbours() {
        return neighbours;
    }

    @Override
    public NodeName getName() {
        return name;
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
