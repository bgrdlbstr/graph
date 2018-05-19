package uk.co.bigredlobster.microtypes.base;

public abstract class BooleanMicroType<T extends Boolean> extends MicroType<T>{
    public BooleanMicroType(T value) {
        super(value);
    }
}
