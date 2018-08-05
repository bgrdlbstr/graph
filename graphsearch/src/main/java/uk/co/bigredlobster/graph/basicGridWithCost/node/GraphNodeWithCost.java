package uk.co.bigredlobster.graph.basicGridWithCost.node;

import uk.co.bigredlobster.graph.shared.node.GraphNode;
import uk.co.bigredlobster.graph.shared.node.GridPosition;
import uk.co.bigredlobster.microtypes.NodeCost;

import java.util.Objects;

public class GraphNodeWithCost {
    public static final GraphNodeWithCost TOP_LEFT = new GraphNodeWithCost(new GraphNode(GridPosition.TOP_LEFT), NodeCost.EMPTY);
    public static final GraphNodeWithCost NOTHING = new GraphNodeWithCost(new GraphNode(GridPosition.NOTHING), NodeCost.EMPTY);

    public final GraphNode node;
    public final NodeCost nodeCost;

    public GraphNodeWithCost(final GraphNode node, final NodeCost nodeCost) {
        this.node = node;
        this.nodeCost = nodeCost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GraphNodeWithCost that = (GraphNodeWithCost) o;
        return Objects.equals(node, that.node) &&
                Objects.equals(nodeCost, that.nodeCost);
    }

    @Override
    public int hashCode() {
        return Objects.hash(node, nodeCost);
    }

    @Override
    public String toString() {
        return "GraphNodeWithCost{" +
                "node=" + node +
                ", nodeCost=" + nodeCost +
                '}';
    }
}
