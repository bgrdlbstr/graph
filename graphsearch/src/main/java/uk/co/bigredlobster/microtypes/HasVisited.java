package uk.co.bigredlobster.microtypes;

import uk.co.bigredlobster.microtypes.base.BooleanMicroType;

public class HasVisited extends BooleanMicroType<Boolean> {

    public HasVisited(Boolean value) {
        super(value);
    }

    @Override
    public String toString() {
        return "HasVisited{}";
    }
}
