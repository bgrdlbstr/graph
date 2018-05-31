package uk.co.bigredlobster.microtypes.base;

public class StringMicroType<T extends String> extends MicroType<T> {
    public static final String EMPTY = "";

    public StringMicroType(T value) {
        super(value);
    }
}
