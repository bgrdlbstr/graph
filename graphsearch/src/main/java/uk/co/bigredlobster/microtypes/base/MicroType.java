package uk.co.bigredlobster.microtypes.base;

import java.util.Objects;

public abstract class MicroType<T> {
    public final T value;

    MicroType(T value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MicroType<?> microType = (MicroType<?>) o;
        return Objects.equals(value, microType.value);
    }

    @Override
    public int hashCode() {

        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "MicroType{" +
                "name=" + value +
                '}';
    }
}
