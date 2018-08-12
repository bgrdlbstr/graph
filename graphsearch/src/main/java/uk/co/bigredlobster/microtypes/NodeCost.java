package uk.co.bigredlobster.microtypes;

import uk.co.bigredlobster.microtypes.base.IntegerMicroType;

public class NodeCost extends IntegerMicroType<Integer> {

    public static final NodeCost EMPTY = new NodeCost(IntegerMicroType.EMPTY);
    public static final NodeCost ONE = new NodeCost(1);
    public static final NodeCost ZERO = new NodeCost(0);

    public NodeCost(final Integer value) {
        super(value);
    }

    public NodeCost(final NodeCost cost) {
        this(cost.value);
    }
}
