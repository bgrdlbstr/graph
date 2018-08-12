package uk.co.bigredlobster.graph;

import org.junit.Test;
import uk.co.bigredlobster.TestWalls;
import uk.co.bigredlobster.graph.basicGridWithWalls.GridGraphWithWalls;
import uk.co.bigredlobster.graph.search.breadthFirst.SearchBreadthFirstWithPathAndEarlyExit;
import uk.co.bigredlobster.graph.shared.node.GraphNode;
import uk.co.bigredlobster.graph.shared.node.GridPosition;
import uk.co.bigredlobster.microtypes.PositionX;
import uk.co.bigredlobster.microtypes.PositionY;
import uk.co.bigredlobster.microtypes.WallPosition;

import java.util.List;
import java.util.Map;

public class TestBreadthFirstEarlyExit {

    @Test
    public void doSearch3Middle() {
        List<WallPosition> walls = TestWalls.walls1;
        GridGraphWithWalls graph = new GridGraphWithWalls(30, 15, walls);
        graph.graphVisualiser.drawGrid(graph);

        System.out.println();
        System.out.println();

        final GraphNode start = new GraphNode(new GridPosition(new PositionX(13), new PositionY(8)));
        final GraphNode goal = new GraphNode(new GridPosition(new PositionX(29), new PositionY(6)));

        SearchBreadthFirstWithPathAndEarlyExit search = new SearchBreadthFirstWithPathAndEarlyExit(graph);
        final Map<GraphNode, GraphNode> search2 = search.search(start, goal);
        search.drawGrid(search2, start, goal);

    }

    @Test
    public void doSearch3Left() {
        List<WallPosition> walls = TestWalls.walls1;
        GridGraphWithWalls graph = new GridGraphWithWalls(30, 15, walls);
        graph.graphVisualiser.drawGrid(graph);

        System.out.println();
        System.out.println();

        final GraphNode start = new GraphNode(GridPosition.TOP_LEFT);
        final GraphNode goal = new GraphNode(new GridPosition(new PositionX(29), new PositionY(6)));

        SearchBreadthFirstWithPathAndEarlyExit search = new SearchBreadthFirstWithPathAndEarlyExit(graph);
        final Map<GraphNode, GraphNode> search2 = search.search(start, goal);
        search.drawGrid(search2, start, goal);

    }

    @Test
    public void doSearch3LeftQuick() {
        List<WallPosition> walls = TestWalls.walls1;
        GridGraphWithWalls graph = new GridGraphWithWalls(30, 15, walls);
        graph.graphVisualiser.drawGrid(graph);

        System.out.println();
        System.out.println();

        final GraphNode start = new GraphNode(GridPosition.TOP_LEFT);
        final GraphNode goal = new GraphNode(new GridPosition(new PositionX(6), new PositionY(6)));

        SearchBreadthFirstWithPathAndEarlyExit search = new SearchBreadthFirstWithPathAndEarlyExit(graph);
        final Map<GraphNode, GraphNode> search2 = search.search(start, goal);
        search.drawGrid(search2, start, goal);

    }

}