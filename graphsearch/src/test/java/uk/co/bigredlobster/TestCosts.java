package uk.co.bigredlobster;

import uk.co.bigredlobster.microtypes.*;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

public class TestCosts {
    public static final List<CostPosition> costs1 = newArrayList(
            new CostPosition(new PositionX(5), new PositionY(5), new NodeCost(5)),
            new CostPosition(new PositionX(5), new PositionY(6), new NodeCost(5)),
            new CostPosition(new PositionX(5), new PositionY(7), new NodeCost(5)),
            new CostPosition(new PositionX(5), new PositionY(8), new NodeCost(5)),
            new CostPosition(new PositionX(5), new PositionY(9), new NodeCost(5)),
            new CostPosition(new PositionX(6), new PositionY(5), new NodeCost(5)),
            new CostPosition(new PositionX(6), new PositionY(6), new NodeCost(5)),
            new CostPosition(new PositionX(6), new PositionY(7), new NodeCost(5)),
            new CostPosition(new PositionX(6), new PositionY(8), new NodeCost(5)),
            new CostPosition(new PositionX(6), new PositionY(9), new NodeCost(5))
    );

    public static final List<CostPosition> costs2 = newArrayList(
            new CostPosition(new PositionX(5), new PositionY(1), new NodeCost(20)),
            new CostPosition(new PositionX(5), new PositionY(2), new NodeCost(20)),
            new CostPosition(new PositionX(5), new PositionY(3), new NodeCost(20)),
            new CostPosition(new PositionX(5), new PositionY(4), new NodeCost(20)),
            new CostPosition(new PositionX(5), new PositionY(5), new NodeCost(20)),
            new CostPosition(new PositionX(5), new PositionY(6), new NodeCost(20)),
            new CostPosition(new PositionX(5), new PositionY(7), new NodeCost(20)),
            new CostPosition(new PositionX(5), new PositionY(8), new NodeCost(20)),
            new CostPosition(new PositionX(5), new PositionY(9), new NodeCost(20)),
            new CostPosition(new PositionX(5), new PositionY(10), new NodeCost(20)),
            new CostPosition(new PositionX(5), new PositionY(11), new NodeCost(20)),
            new CostPosition(new PositionX(5), new PositionY(12), new NodeCost(20)),
            new CostPosition(new PositionX(5), new PositionY(13), new NodeCost(20)),
            new CostPosition(new PositionX(6), new PositionY(5), new NodeCost(20)),
            new CostPosition(new PositionX(6), new PositionY(6), new NodeCost(20)),
            new CostPosition(new PositionX(6), new PositionY(7), new NodeCost(20)),
            new CostPosition(new PositionX(6), new PositionY(8), new NodeCost(20)),
            new CostPosition(new PositionX(6), new PositionY(9), new NodeCost(20)),
            new CostPosition(new PositionX(6), new PositionY(10), new NodeCost(20)),
            new CostPosition(new PositionX(6), new PositionY(11), new NodeCost(20)),
            new CostPosition(new PositionX(6), new PositionY(12), new NodeCost(20)),
            new CostPosition(new PositionX(6), new PositionY(13), new NodeCost(20)),

            new CostPosition(new PositionX(8), new PositionY(14), new NodeCost(20)),
            new CostPosition(new PositionX(8), new PositionY(13), new NodeCost(20)),
            new CostPosition(new PositionX(8), new PositionY(12), new NodeCost(20)),
            new CostPosition(new PositionX(8), new PositionY(11), new NodeCost(20)),
            new CostPosition(new PositionX(8), new PositionY(10), new NodeCost(20)),
            new CostPosition(new PositionX(8), new PositionY(9), new NodeCost(20)),
            new CostPosition(new PositionX(8), new PositionY(8), new NodeCost(20)),
            new CostPosition(new PositionX(8), new PositionY(7), new NodeCost(20)),

            new CostPosition(new PositionX(9), new PositionY(0), new NodeCost(20)),
            new CostPosition(new PositionX(9), new PositionY(1), new NodeCost(20)),
            new CostPosition(new PositionX(9), new PositionY(2), new NodeCost(20)),
            new CostPosition(new PositionX(9), new PositionY(3), new NodeCost(20)),
            new CostPosition(new PositionX(9), new PositionY(4), new NodeCost(20))
    );
}
