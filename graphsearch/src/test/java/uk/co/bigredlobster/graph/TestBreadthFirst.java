package uk.co.bigredlobster.graph;

import org.junit.Test;
import uk.co.bigredlobster.TestWalls;
import uk.co.bigredlobster.graph.basicGridWithWalls.GridGraphWithWalls;
import uk.co.bigredlobster.graph.search.breadthFirst.SearchBreadthFirst;
import uk.co.bigredlobster.graph.shared.node.GraphNode;
import uk.co.bigredlobster.graph.shared.node.GridPosition;
import uk.co.bigredlobster.microtypes.HasVisitedAndWhen;
import uk.co.bigredlobster.microtypes.PositionX;
import uk.co.bigredlobster.microtypes.PositionY;
import uk.co.bigredlobster.microtypes.WallPosition;

import java.util.List;
import java.util.Map;

public class TestBreadthFirst {

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
}