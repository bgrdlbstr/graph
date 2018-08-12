package uk.co.bigredlobster.microtypes;

import uk.co.bigredlobster.microtypes.base.IntegerMicroType;

public class PositionY extends IntegerMicroType<Integer> {

    public static PositionY EMPTY = new PositionY(IntegerMicroType.EMPTY);

    public PositionY(final int y) {
        super(Integer.valueOf(y));
    }

    public PositionY(final Integer y) {
        super(y);
    }

    public PositionY(final PositionY y) {
        this(y.value);
    }
}
