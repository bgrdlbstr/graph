package uk.co.bigredlobster.graph.shared.node;

import uk.co.bigredlobster.microtypes.PositionX;
import uk.co.bigredlobster.microtypes.PositionY;

import java.util.Objects;

public class GridPosition {
    public static final GridPosition TOP_LEFT = new GridPosition(new PositionX(0), new PositionY(0));
    public static final GridPosition NOTHING = new GridPosition(new PositionX(Integer.MIN_VALUE), new PositionY(Integer.MIN_VALUE));

    public final PositionX x;
    public final PositionY y;

    public GridPosition(final PositionX x, final PositionY y) {
        this.x = x;
        this.y = y;
    }

    public GridPosition(final GridPosition position) {
        this(position.x, position.y);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GridPosition position = (GridPosition) o;
        return Objects.equals(x, position.x) &&
                Objects.equals(y, position.y);
    }

    @Override
    public int hashCode() {

        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "GridPosition{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
