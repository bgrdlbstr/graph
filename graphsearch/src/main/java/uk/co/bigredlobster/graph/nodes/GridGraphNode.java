package uk.co.bigredlobster.graph.nodes;

import uk.co.bigredlobster.microtypes.NodeName;
import uk.co.bigredlobster.microtypes.PositionX;
import uk.co.bigredlobster.microtypes.PositionY;

import java.util.Objects;
import java.util.Set;

public class GridGraphNode implements IGraphNode {

    private final IGraphNode graphNode;
    public final PositionX x;
    public final PositionY y;

    public GridGraphNode(final IGraphNode graphNode, final PositionX x, final PositionY y) {
        this.graphNode = graphNode;
        this.x = x;
        this.y = y;
    }

    public GridGraphNode(final IGraphNode graphNode) {
        this.graphNode = graphNode;
        this.x = PositionX.EMPTY;
        this.y = PositionY.EMPTY;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GridGraphNode that = (GridGraphNode) o;
        return Objects.equals(graphNode, that.graphNode);
    }

    @Override
    public int hashCode() {

        return Objects.hash(graphNode);
    }

    @Override
    public String toString() {
        return "GridGraphNode{" +
                "graphNode=" + graphNode +
                ", x=" + x +
                ", y=" + y +
                '}';
    }

    @Override
    public Set<IGraphNode> getNeighbours() {
        return graphNode.getNeighbours();
    }

    @Override
    public NodeName getName() {
        return graphNode.getName();
    }
}
