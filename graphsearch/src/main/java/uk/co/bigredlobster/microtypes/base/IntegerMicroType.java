package uk.co.bigredlobster.microtypes.base;

public class IntegerMicroType<T extends Integer> extends MicroType<T> {
    protected static final int EMPTY = Integer.MIN_VALUE;

    public IntegerMicroType(T value) {
        super(value);
    }
}
