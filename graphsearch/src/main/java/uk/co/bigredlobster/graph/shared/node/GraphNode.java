package uk.co.bigredlobster.graph.shared.node;

import java.util.Objects;

public class GraphNode {
    public static final GraphNode TOP_LEFT = new GraphNode(GridPosition.TOP_LEFT);
    public static final GraphNode NOTHING = new GraphNode(GridPosition.NOTHING);

    public final GridPosition position;

    public GraphNode(final GridPosition position) {
        this.position = position;
    }

    public GraphNode(final GraphNode node) {
        this(node.position);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GraphNode graphNode = (GraphNode) o;
        return Objects.equals(position, graphNode.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }

    @Override
    public String toString() {
        return "GraphNode{" +
                "position=" + position +
                '}';
    }
}
