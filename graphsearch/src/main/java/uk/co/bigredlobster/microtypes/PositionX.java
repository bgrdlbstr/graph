package uk.co.bigredlobster.microtypes;

import uk.co.bigredlobster.microtypes.base.IntegerMicroType;

public class PositionX extends IntegerMicroType<Integer> {

    public static PositionX EMPTY = new PositionX(IntegerMicroType.EMPTY);

    public PositionX(final Integer x) {
        super(x);
    }

    public PositionX(final int x) {
        super(Integer.valueOf(x));
    }

    public PositionX(final PositionX x) {
        this(x.value);
    }
}
