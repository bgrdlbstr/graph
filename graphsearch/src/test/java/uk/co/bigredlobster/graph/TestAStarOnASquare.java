package uk.co.bigredlobster.graph;

import org.junit.Test;
import uk.co.bigredlobster.TestWalls;
import uk.co.bigredlobster.graph.basicGridWithCost.GridGraphWithWallsAndCost;
import uk.co.bigredlobster.graph.search.cost.CostAndCameFrom;
import uk.co.bigredlobster.graph.search.cost.GraphNodeWithCost;
import uk.co.bigredlobster.graph.search.cost.aStar.SearchAStarWithPathAndEarlyExit;
import uk.co.bigredlobster.graph.shared.helpers.DrawStyle;
import uk.co.bigredlobster.graph.shared.node.GraphNode;
import uk.co.bigredlobster.graph.shared.node.GridPosition;
import uk.co.bigredlobster.microtypes.*;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;

public class TestAStarOnASquare {

    @Test
    public void doSearch5Left() {
        List<WallPosition> walls = TestWalls.walls2;
        final List<CostPosition> costs = new ArrayList<>();
        GridGraphWithWallsAndCost graph = new GridGraphWithWallsAndCost(15, 15, walls, costs);
        graph.graphVisualiser.drawGrid(graph);

        System.out.println();
        System.out.println();

        final GraphNodeWithCost start = new GraphNodeWithCost(new GraphNode(GridPosition.TOP_LEFT), NodeCost.ONE);
        final GraphNodeWithCost goal = new GraphNodeWithCost(new GraphNode(new GridPosition(new PositionX(14), new PositionY(5))), NodeCost.ONE);

        SearchAStarWithPathAndEarlyExit search = new SearchAStarWithPathAndEarlyExit(graph);
        final CostAndCameFrom search2 = search.search(start, goal);
        search.drawGrid(search2, start, goal, DrawStyle.PATH);
        search.drawGrid(search2, start, goal, DrawStyle.COST_SO_FAR);

        final int max = search2.costSoFar.values().stream().mapToInt(x -> x.value).max().orElseThrow(RuntimeException::new);
        assertThat(max, org.hamcrest.core.Is.is((19)));

    }

    @Test
    public void doSearch6Middle() {
        List<WallPosition> walls = TestWalls.walls2;
        final List<CostPosition> costs = new ArrayList<>();
        GridGraphWithWallsAndCost graph = new GridGraphWithWallsAndCost(15, 15, walls, costs);
        graph.graphVisualiser.drawGrid(graph);

        System.out.println();
        System.out.println();

        final GraphNodeWithCost start = new GraphNodeWithCost(new GraphNode(new GridPosition(new PositionX(1), new PositionY(8))), NodeCost.ONE);
        final GraphNodeWithCost goal = new GraphNodeWithCost(new GraphNode(new GridPosition(new PositionX(14), new PositionY(8))), NodeCost.ONE);

        SearchAStarWithPathAndEarlyExit search = new SearchAStarWithPathAndEarlyExit(graph);
        final CostAndCameFrom search2 = search.search(start, goal);
        search.drawGrid(search2, start, goal, DrawStyle.PATH);
        search.drawGrid(search2, start, goal, DrawStyle.COST_SO_FAR);

        final int max = search2.costSoFar.values().stream().mapToInt(x -> x.value).max().orElseThrow(RuntimeException::new);
        assertThat(max, org.hamcrest.core.Is.is((21)));
    }
}