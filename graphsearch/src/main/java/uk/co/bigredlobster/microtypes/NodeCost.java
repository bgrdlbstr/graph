package uk.co.bigredlobster.microtypes;

import uk.co.bigredlobster.microtypes.base.IntegerMicroType;

public class NodeCost extends IntegerMicroType<Integer> {

    public static final NodeCost EMPTY = new NodeCost(IntegerMicroType.EMPTY);

    public NodeCost(final Integer value) {
        super(value);
    }
}
