package uk.co.bigredlobster.microtypes;

import uk.co.bigredlobster.graph.shared.node.GridPosition;

import java.util.Objects;

public class CostPosition extends GridPosition {
    public final NodeCost cost;

    public CostPosition(final PositionX x, final PositionY y, final NodeCost cost) {
        super(x, y);
        this.cost = cost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        CostPosition that = (CostPosition) o;
        return Objects.equals(cost, that.cost);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), cost);
    }

    @Override
    public String toString() {
        return "CostPosition{" +
                "cost=" + cost +
                '}';
    }
}
