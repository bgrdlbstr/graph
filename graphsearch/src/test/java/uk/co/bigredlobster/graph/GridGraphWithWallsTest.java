package uk.co.bigredlobster.graph;

import org.junit.Test;
import uk.co.bigredlobster.TestWalls;
import uk.co.bigredlobster.graph.basicGridWithWalls.GridGraphWithWalls;
import uk.co.bigredlobster.graph.shared.node.GraphNode;
import uk.co.bigredlobster.graph.shared.node.GridPosition;
import uk.co.bigredlobster.graph.search.breadthFirst.SearchBreadthFirst;
import uk.co.bigredlobster.graph.search.breadthFirst.SearchBreadthFirstWithPath;
import uk.co.bigredlobster.graph.search.breadthFirst.SearchBreadthFirstWithPathAndEarlyExit;
import uk.co.bigredlobster.microtypes.HasVisitedAndWhen;
import uk.co.bigredlobster.microtypes.PositionX;
import uk.co.bigredlobster.microtypes.PositionY;
import uk.co.bigredlobster.microtypes.WallPosition;

import java.util.List;
import java.util.Map;

public class GridGraphWithWallsTest {

    @Test
    public void doIt() {
        List<WallPosition> walls = TestWalls.walls1;
        GridGraphWithWalls graph = new GridGraphWithWalls(30, 15, walls);
        graph.graphVisualiser.drawGrid(graph);

        System.out.println();
        System.out.println();

        SearchBreadthFirst searchBreadthFirst = new SearchBreadthFirst(graph);
        final Map<GraphNode, HasVisitedAndWhen> search = searchBreadthFirst.search(new GraphNode(GridPosition.TOP_LEFT));
        searchBreadthFirst.drawGrid(search);
    }

    @Test
    public void doIt2() {
        List<WallPosition> walls = TestWalls.walls1;
        GridGraphWithWalls graph = new GridGraphWithWalls(30, 15, walls);
        graph.graphVisualiser.drawGrid(graph);

        System.out.println();
        System.out.println();

        SearchBreadthFirst searchBreadthFirst = new SearchBreadthFirst(graph);
        final Map<GraphNode, HasVisitedAndWhen> search = searchBreadthFirst.search(new GraphNode(new GridPosition(new PositionX(13), new PositionY(8))));
        searchBreadthFirst.drawGrid(search);
    }

    @Test
    public void doSearch2() {
        List<WallPosition> walls = TestWalls.walls1;
        GridGraphWithWalls graph = new GridGraphWithWalls(30, 15, walls);
        graph.graphVisualiser.drawGrid(graph);

        System.out.println();
        System.out.println();

        SearchBreadthFirstWithPath searchBreadthFirstWithPath = new SearchBreadthFirstWithPath(graph);
        final Map<GraphNode, GraphNode> search2 = searchBreadthFirstWithPath.search(new GraphNode(GridPosition.TOP_LEFT));
        searchBreadthFirstWithPath.drawGrid(search2);

    }

    @Test
    public void doSearch2Middle() {
        List<WallPosition> walls = TestWalls.walls1;
        GridGraphWithWalls graph = new GridGraphWithWalls(30, 15, walls);
        graph.graphVisualiser.drawGrid(graph);

        System.out.println();
        System.out.println();

        SearchBreadthFirstWithPath searchBreadthFirstWithPath = new SearchBreadthFirstWithPath(graph);
        final Map<GraphNode, GraphNode> search2 = searchBreadthFirstWithPath.search(new GraphNode(new GridPosition(new PositionX(13), new PositionY(8))));
        searchBreadthFirstWithPath.drawGrid(search2);

    }

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