package uk.co.bigredlobster.microtypes;

import uk.co.bigredlobster.microtypes.base.IntegerMicroType;

public class WhenVisited extends IntegerMicroType<Integer> {
    public static final WhenVisited EMPTY = new WhenVisited(IntegerMicroType.EMPTY);

    public WhenVisited(Integer value) {
        super(value);
    }
}
