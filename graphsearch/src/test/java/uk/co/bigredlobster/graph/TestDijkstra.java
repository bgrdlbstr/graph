package uk.co.bigredlobster.graph;

import org.junit.Test;
import uk.co.bigredlobster.TestCosts;
import uk.co.bigredlobster.TestWalls;
import uk.co.bigredlobster.graph.basicGridWithCost.GridGraphWithWallsAndCost;
import uk.co.bigredlobster.graph.search.cost.CostAndCameFrom;
import uk.co.bigredlobster.graph.search.cost.GraphNodeWithCost;
import uk.co.bigredlobster.graph.search.cost.dijsktra.SearchUniformCostWithPathAndEarlyExit;
import uk.co.bigredlobster.graph.shared.helpers.DrawStyle;
import uk.co.bigredlobster.graph.shared.node.GraphNode;
import uk.co.bigredlobster.graph.shared.node.GridPosition;
import uk.co.bigredlobster.microtypes.*;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;

public class TestDijkstra {

    @Test
    public void doSearch4Left() {
        List<WallPosition> walls = TestWalls.walls1;
        final List<CostPosition> costs = TestCosts.costs1;
        GridGraphWithWallsAndCost graph = new GridGraphWithWallsAndCost(30, 15, walls, costs);
        graph.graphVisualiser.drawGrid(graph);

        System.out.println();
        System.out.println();

        final GraphNodeWithCost start = new GraphNodeWithCost(new GraphNode(GridPosition.TOP_LEFT), NodeCost.ONE);
        final GraphNodeWithCost goal = new GraphNodeWithCost(new GraphNode(new GridPosition(new PositionX(29), new PositionY(10))), NodeCost.ONE);

        SearchUniformCostWithPathAndEarlyExit search = new SearchUniformCostWithPathAndEarlyExit(graph);
        final CostAndCameFrom search2 = search.search(start, goal);
        search.drawGrid(search2, start, goal, DrawStyle.PATH);
        search.drawGrid(search2, start, goal, DrawStyle.COST_SO_FAR);

        final int max = search2.costSoFar.values().stream().mapToInt(x -> x.value).max().orElseThrow(RuntimeException::new);
        assertThat(max, org.hamcrest.core.Is.is((45)));
    }

}