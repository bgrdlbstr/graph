package uk.co.bigredlobster.microtypes;

import java.util.Objects;

public class HasVisitedAndWhen {
    public final HasVisited hasVisited;
    public final WhenVisited when;

    public HasVisitedAndWhen(final HasVisited hasVisited, final WhenVisited when) {
        this.hasVisited = hasVisited;
        this.when = when;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HasVisitedAndWhen that = (HasVisitedAndWhen) o;
        return Objects.equals(hasVisited, that.hasVisited) &&
                Objects.equals(when, that.when);
    }

    @Override
    public int hashCode() {

        return Objects.hash(hasVisited, when);
    }

    @Override
    public String toString() {
        return "HasVisitedAndWhen{" +
                "hasVisited=" + hasVisited +
                ", when=" + when +
                '}';
    }
}
