package uk.co.bigredlobster.microtypes;

import uk.co.bigredlobster.microtypes.base.StringMicroType;

public class NodeName extends StringMicroType<String> {
    public static final NodeName EMPTY = new NodeName(StringMicroType.EMPTY);

    public NodeName(String value) {
        super(value);
    }
}
