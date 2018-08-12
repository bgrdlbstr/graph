package uk.co.bigredlobster;

import uk.co.bigredlobster.microtypes.PositionX;
import uk.co.bigredlobster.microtypes.PositionY;
import uk.co.bigredlobster.microtypes.WallPosition;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

public class TestWalls {
    public static final List<WallPosition> walls1 = newArrayList(
            new WallPosition(new PositionX(30), new PositionY(0)),
            new WallPosition(new PositionX(30), new PositionY(1)),
            new WallPosition(new PositionX(30), new PositionY(2)),
            new WallPosition(new PositionX(30), new PositionY(3)),
            new WallPosition(new PositionX(30), new PositionY(4)),
            new WallPosition(new PositionX(30), new PositionY(5)),
            new WallPosition(new PositionX(31), new PositionY(0)),
            new WallPosition(new PositionX(31), new PositionY(1)),
            new WallPosition(new PositionX(31), new PositionY(2)),
            new WallPosition(new PositionX(31), new PositionY(3)),
            new WallPosition(new PositionX(31), new PositionY(4)),
            new WallPosition(new PositionX(31), new PositionY(5)),
            new WallPosition(new PositionX(32), new PositionY(4)),
            new WallPosition(new PositionX(32), new PositionY(5)),

            new WallPosition(new PositionX(10), new PositionY(5)),
            new WallPosition(new PositionX(10), new PositionY(6)),
            new WallPosition(new PositionX(10), new PositionY(7)),
            new WallPosition(new PositionX(10), new PositionY(8)),
            new WallPosition(new PositionX(10), new PositionY(9)),
            new WallPosition(new PositionX(11), new PositionY(5)),
            new WallPosition(new PositionX(11), new PositionY(6)),
            new WallPosition(new PositionX(11), new PositionY(7)),
            new WallPosition(new PositionX(11), new PositionY(8)),
            new WallPosition(new PositionX(11), new PositionY(9)),

            new WallPosition(new PositionX(20), new PositionY(3)),
            new WallPosition(new PositionX(20), new PositionY(4)),
            new WallPosition(new PositionX(20), new PositionY(5)),
            new WallPosition(new PositionX(20), new PositionY(6)),
            new WallPosition(new PositionX(20), new PositionY(7)),
            new WallPosition(new PositionX(20), new PositionY(8)),
            new WallPosition(new PositionX(21), new PositionY(3)),
            new WallPosition(new PositionX(21), new PositionY(4)),
            new WallPosition(new PositionX(21), new PositionY(5)),
            new WallPosition(new PositionX(21), new PositionY(6)),
            new WallPosition(new PositionX(21), new PositionY(7)),
            new WallPosition(new PositionX(21), new PositionY(8))
    );

    public static final List<WallPosition> walls2 = newArrayList(
            new WallPosition(new PositionX(5), new PositionY(2)),
            new WallPosition(new PositionX(6), new PositionY(2)),
            new WallPosition(new PositionX(7), new PositionY(2)),
            new WallPosition(new PositionX(8), new PositionY(2)),
            new WallPosition(new PositionX(9), new PositionY(2)),
            new WallPosition(new PositionX(10), new PositionY(2)),
            new WallPosition(new PositionX(11), new PositionY(2)),
            new WallPosition(new PositionX(12), new PositionY(2)),

            new WallPosition(new PositionX(12), new PositionY(3)),
            new WallPosition(new PositionX(12), new PositionY(4)),
            new WallPosition(new PositionX(12), new PositionY(5)),
            new WallPosition(new PositionX(12), new PositionY(6)),
            new WallPosition(new PositionX(12), new PositionY(7)),
            new WallPosition(new PositionX(12), new PositionY(8)),
            new WallPosition(new PositionX(12), new PositionY(9)),
            new WallPosition(new PositionX(12), new PositionY(10)),
            new WallPosition(new PositionX(12), new PositionY(11)),

            new WallPosition(new PositionX(11), new PositionY(11)),
            new WallPosition(new PositionX(10), new PositionY(11)),
            new WallPosition(new PositionX(9), new PositionY(11)),
            new WallPosition(new PositionX(8), new PositionY(11)),
            new WallPosition(new PositionX(7), new PositionY(11)),
            new WallPosition(new PositionX(6), new PositionY(11)),
            new WallPosition(new PositionX(5), new PositionY(11))
    );
}
