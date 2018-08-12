package uk.co.bigredlobster.graph.search.cost;

import uk.co.bigredlobster.graph.shared.node.GraphNode;
import uk.co.bigredlobster.microtypes.NodeCost;

import java.util.Objects;

public class GraphNodeWithCost {

    public final GraphNode graphNode;
    public final NodeCost cost;

    public GraphNodeWithCost(final GraphNode graphNode, final NodeCost cost) {
        this.graphNode = graphNode;
        this.cost = cost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GraphNodeWithCost that = (GraphNodeWithCost) o;
        return graphNode.equals(that.graphNode);
    }

    @Override
    public int hashCode() {
        return graphNode.hashCode();
    }

    @Override
    public String toString() {
        return "GraphNodeWithCost{" +
                "graphNode=" + graphNode +
                ", cost=" + cost +
                '}';
    }
}
