package uk.co.bigredlobster.homegrownGraph;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;
import org.junit.Test;
import uk.co.bigredlobster.homegrownGraph.graphs.GraphFactory;
import uk.co.bigredlobster.homegrownGraph.graphs.IGraphSearch;
import uk.co.bigredlobster.homegrownGraph.nodes.GraphNode;
import uk.co.bigredlobster.homegrownGraph.nodes.GridGraphNode;
import uk.co.bigredlobster.homegrownGraph.nodes.IGraphNode;
import uk.co.bigredlobster.homegrownGraph.searchAlgos.GraphSearchBreadthFirst;
import uk.co.bigredlobster.microtypes.HasVisitedAndWhen;
import uk.co.bigredlobster.microtypes.NodeName;
import uk.co.bigredlobster.microtypes.WallPosition;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static uk.co.bigredlobster.homegrownGraph.TestWalls.walls1;

public class GridGraphWithWallsSearchBreadthFirstTest {

    @Test
    public void testNumberOfNodesVisited() {
        final IGraph simpleGraph = GraphFactory.getGridGraphWithWalls(50, 10, walls1);
        final IGraphSearch search = new GraphSearchBreadthFirst(simpleGraph);

        final IGraphNode node3 = new GridGraphNode(new GraphNode(new NodeName("3")));
        final Map<IGraphNode, HasVisitedAndWhen> visited = search.search(node3);

        final int expectedNumberOfVisitedNodes = simpleGraph.edges().size() - walls1.size();
        assertThat(visited.size(), is(expectedNumberOfVisitedNodes));
        assertThat(visited.values().stream().filter(x -> x.hasVisited.value).count(), is((long) expectedNumberOfVisitedNodes));
    }

    @Test
    public void testOnlyUnvisitedNodesAreWalls() {
        final IGraph simpleGraph = GraphFactory.getGridGraph(50, 10);
        final IGraphSearch search = new GraphSearchBreadthFirst(simpleGraph);

        final IGraphNode node3 = new GridGraphNode(new GraphNode(new NodeName("3")));
        final Map<IGraphNode, HasVisitedAndWhen> visited = search.search(node3);

        final Set<IGraphNode> visitedNodes = visited.keySet();
        final ImmutableSet<IGraphNode> allNodes = simpleGraph.edges().keySet();

        final ImmutableSet<IGraphNode> difference = Sets.difference(visitedNodes, allNodes).immutableCopy();
        final Set<WallPosition> expectedWalls = difference.stream().map(z -> new WallPosition(((GridGraphNode) z).x, ((GridGraphNode) z).y)).collect(Collectors.toSet());

        assertThat(Sets.difference(expectedWalls, ImmutableSet.copyOf(walls1)).size(), is(0));
    }
}