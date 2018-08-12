package uk.co.bigredlobster.graph;

import org.junit.Test;
import uk.co.bigredlobster.TestCosts;
import uk.co.bigredlobster.TestWalls;
import uk.co.bigredlobster.graph.basicGridWithCost.GridGraphWithWallsAndCost;
import uk.co.bigredlobster.graph.search.cost.CostAndCameFrom;
import uk.co.bigredlobster.graph.search.cost.GraphNodeWithCost;
import uk.co.bigredlobster.graph.search.cost.aStar.SearchAStarWithPathAndEarlyExit;
import uk.co.bigredlobster.graph.shared.helpers.DrawStyle;
import uk.co.bigredlobster.graph.shared.node.GraphNode;
import uk.co.bigredlobster.graph.shared.node.GridPosition;
import uk.co.bigredlobster.microtypes.*;

import java.util.List;

public class TestAStarExtraCosts {

    @Test
    public void doSearch5Left() {
        List<WallPosition> walls = TestWalls.walls1;
        final List<CostPosition> costs = TestCosts.costs2;
        GridGraphWithWallsAndCost graph = new GridGraphWithWallsAndCost(30, 15, walls, costs);
        graph.graphVisualiser.drawGrid(graph);

        System.out.println();
        System.out.println();

        final GraphNodeWithCost start = new GraphNodeWithCost(new GraphNode(GridPosition.TOP_LEFT), NodeCost.ONE);
        final GraphNodeWithCost goal = new GraphNodeWithCost(new GraphNode(new GridPosition(new PositionX(14), new PositionY(5))), NodeCost.ONE);

        SearchAStarWithPathAndEarlyExit search = new SearchAStarWithPathAndEarlyExit(graph);
        final CostAndCameFrom search2 = search.search(start, goal);
        search.drawGrid(search2, start, goal, DrawStyle.PATH);
        search.drawGrid(search2, start, goal, DrawStyle.COST_SO_FAR);
    }

    @Test
    public void doSearch6Middle() {
        List<WallPosition> walls = TestWalls.walls1;
        final List<CostPosition> costs = TestCosts.costs2;
        GridGraphWithWallsAndCost graph = new GridGraphWithWallsAndCost(30, 15, walls, costs);
        graph.graphVisualiser.drawGrid(graph);

        System.out.println();
        System.out.println();

        final GraphNodeWithCost start = new GraphNodeWithCost(new GraphNode(new GridPosition(new PositionX(1), new PositionY(8))), NodeCost.ONE);
        final GraphNodeWithCost goal = new GraphNodeWithCost(new GraphNode(new GridPosition(new PositionX(14), new PositionY(8))), NodeCost.ONE);

        SearchAStarWithPathAndEarlyExit search = new SearchAStarWithPathAndEarlyExit(graph);
        final CostAndCameFrom search2 = search.search(start, goal);
        search.drawGrid(search2, start, goal, DrawStyle.PATH);
        search.drawGrid(search2, start, goal, DrawStyle.COST_SO_FAR);
    }

    @Test
    public void doSearch6Right() {
        List<WallPosition> walls = TestWalls.walls1;
        final List<CostPosition> costs = TestCosts.costs2;
        GridGraphWithWallsAndCost graph = new GridGraphWithWallsAndCost(30, 15, walls, costs);
        graph.graphVisualiser.drawGrid(graph);

        System.out.println();
        System.out.println();

        final GraphNodeWithCost start = new GraphNodeWithCost(new GraphNode(new GridPosition(new PositionX(1), new PositionY(8))), NodeCost.ONE);
        final GraphNodeWithCost goal = new GraphNodeWithCost(new GraphNode(new GridPosition(new PositionX(29), new PositionY(3))), NodeCost.ONE);

        SearchAStarWithPathAndEarlyExit search = new SearchAStarWithPathAndEarlyExit(graph);
        final CostAndCameFrom search2 = search.search(start, goal);
        search.drawGrid(search2, start, goal, DrawStyle.PATH);
        search.drawGrid(search2, start, goal, DrawStyle.COST_SO_FAR);
    }
}