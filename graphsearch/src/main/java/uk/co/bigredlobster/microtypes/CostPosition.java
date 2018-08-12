package uk.co.bigredlobster.microtypes;

import uk.co.bigredlobster.graph.shared.node.GridPosition;

public class CostPosition extends GridPosition {
    public final NodeCost cost;

    public CostPosition(final PositionX x, final PositionY y, final NodeCost cost) {
        super(x, y);
        this.cost = cost;
    }

    public CostPosition(final GridPosition position, final NodeCost cost) {
        this(position.x, position.y, cost);
    }

    public CostPosition(final CostPosition costPosition) {
        this(costPosition.x, costPosition.y, costPosition.cost);
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return "CostPosition{" +
                "cost=" + cost +
                '}';
    }
}
