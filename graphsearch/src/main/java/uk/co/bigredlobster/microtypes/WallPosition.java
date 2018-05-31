package uk.co.bigredlobster.microtypes;

import java.util.Objects;

import static com.google.common.base.Preconditions.checkNotNull;

public class WallPosition {
    private final PositionX x;
    private final PositionY y;

    public WallPosition(final PositionX x, final PositionY y) {
        this.x = checkNotNull(x);
        this.y = checkNotNull(y);
    }

    @Override
    public String toString() {
        return "WallPosition{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WallPosition that = (WallPosition) o;
        return Objects.equals(x, that.x) &&
                Objects.equals(y, that.y);
    }

    @Override
    public int hashCode() {

        return Objects.hash(x, y);
    }
}
