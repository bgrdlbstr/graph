package uk.co.bigredlobster.graph;

import com.google.common.collect.Lists;
import org.junit.Test;
import uk.co.bigredlobster.graph.builders.GridGraphBuilder;
import uk.co.bigredlobster.graph.nodes.IGraphNode;
import uk.co.bigredlobster.graph.nodes.basic.GraphNode;
import uk.co.bigredlobster.graph.nodes.grid.GridGraphNode;
import uk.co.bigredlobster.graph.searchAlgos.GraphSearchBreadthFirst;
import uk.co.bigredlobster.graph.searchAlgos.IGraphSearch;
import uk.co.bigredlobster.microtypes.HasVisitedAndWhen;
import uk.co.bigredlobster.microtypes.PositionX;
import uk.co.bigredlobster.microtypes.PositionY;
import uk.co.bigredlobster.microtypes.WhenVisited;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

import static junit.framework.TestCase.assertEquals;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class GridGraphSearchBreadthFirstTest {

    @Test
    public void testSearchTopRowNode() {
        final SimpleGraph simpleGraph = new GridGraphBuilder(50, 10).build();
        final IGraphSearch search = new GraphSearchBreadthFirst(simpleGraph);

        final IGraphNode node3 = new GridGraphNode(new GraphNode("3"));
        final Map<IGraphNode, HasVisitedAndWhen> visited = search.search(node3);

        assertThat(visited.size(), is(simpleGraph.edges.size()));
        assertThat(visited.values().stream().filter(x -> x.hasVisited.value).count(), is((long) simpleGraph.edges.size()));

        final Set<IGraphNode> neighbours = simpleGraph.neighbours(node3);
        assertThat(neighbours.size(), is(3));

        final ArrayList<IGraphNode> iGraphNodes = Lists.newArrayList(neighbours);
        final IGraphNode iGraphNode = iGraphNodes.get(0);
        final IGraphNode iGraphNode2 = iGraphNodes.get(1);
        final IGraphNode iGraphNode3 = iGraphNodes.get(2);

        assertThat(iGraphNode, is(new GridGraphNode(new GraphNode("2"), new PositionX(2), new PositionY(0))));
        assertThat(iGraphNode2, is(new GridGraphNode(new GraphNode("4"), new PositionX(4), new PositionY(0))));
        assertThat(iGraphNode3, is(new GridGraphNode(new GraphNode("53"), new PositionX(12), new PositionY(1))));

        assertThat(visited.containsKey(iGraphNode), is(true));
        assertThat(visited.containsKey(iGraphNode2), is(true));
        assertThat(visited.containsKey(iGraphNode3), is(true));

        System.out.println("iGraphNode = " + iGraphNode);
        assertThat(visited.get(iGraphNode).hasVisited.value, is(true));
        assertEquals(2, (int) visited.get(iGraphNode).when.value);

        System.out.println("iGraphNode2 = " + iGraphNode2);
        assertThat(visited.get(iGraphNode2).hasVisited.value, is(true));
        assertEquals(3, (int) visited.get(iGraphNode2).when.value);

        System.out.println("iGraphNode3 = " + iGraphNode3);
        assertThat(visited.get(iGraphNode3).hasVisited.value, is(true));
        assertEquals(4, (int) visited.get(iGraphNode3).when.value);
    }

    @Test
    public void testSearchTopLeftCornerNode() {
        final SimpleGraph simpleGraph = new GridGraphBuilder(50, 10).build();
        final IGraphSearch search = new GraphSearchBreadthFirst(simpleGraph);

        final IGraphNode node0 = new GridGraphNode(new GraphNode("0"));
        final Map<IGraphNode, HasVisitedAndWhen> visited = search.search(node0);

        assertThat(visited.size(), is(simpleGraph.edges.size()));
        assertThat(visited.values().stream().filter(x -> x.hasVisited.value).count(), is((long) simpleGraph.edges.size()));

        final Set<IGraphNode> neighbours = simpleGraph.neighbours(node0);
        assertThat(neighbours.size(), is(2));

        final ArrayList<IGraphNode> iGraphNodes = Lists.newArrayList(neighbours);
        final IGraphNode iGraphNode = iGraphNodes.get(0);
        final IGraphNode iGraphNode2 = iGraphNodes.get(1);

        assertThat(iGraphNode, is(new GridGraphNode(new GraphNode("1"), new PositionX(1), new PositionY(0))));
        assertThat(iGraphNode2, is(new GridGraphNode(new GraphNode("50"), new PositionX(0), new PositionY(1))));

        assertThat(visited.containsKey(iGraphNode), is(true));
        assertThat(visited.containsKey(iGraphNode2), is(true));

        System.out.println("iGraphNode = " + iGraphNode);
        assertThat(visited.get(iGraphNode).hasVisited.value, is(true));
        assertEquals(2, (int) visited.get(iGraphNode).when.value);

        System.out.println("iGraphNode2 = " + iGraphNode2);
        assertThat(visited.get(iGraphNode2).hasVisited.value, is(true));
        assertEquals(3, (int) visited.get(iGraphNode2).when.value);
    }

    @Test
    public void testSearchTopRightCornerNode() {
        final SimpleGraph simpleGraph = new GridGraphBuilder(50, 10).build();
        final IGraphSearch search = new GraphSearchBreadthFirst(simpleGraph);

        final IGraphNode node49 = new GridGraphNode(new GraphNode("49"));
        final Map<IGraphNode, HasVisitedAndWhen> visited = search.search(node49);

        assertThat(visited.size(), is(simpleGraph.edges.size()));
        assertThat(visited.values().stream().filter(x -> x.hasVisited.value).count(), is((long) simpleGraph.edges.size()));

        final Set<IGraphNode> neighbours = simpleGraph.neighbours(node49);
        assertThat(neighbours.size(), is(2));

        final ArrayList<IGraphNode> iGraphNodes = Lists.newArrayList(neighbours);
        final IGraphNode iGraphNode = iGraphNodes.get(0);
        final IGraphNode iGraphNode2 = iGraphNodes.get(1);

        assertThat(iGraphNode, is(new GridGraphNode(new GraphNode("48"), new PositionX(48), new PositionY(0))));
        assertThat(iGraphNode2, is(new GridGraphNode(new GraphNode("99"), new PositionX(49), new PositionY(1))));

        assertThat(visited.containsKey(iGraphNode), is(true));
        assertThat(visited.containsKey(iGraphNode2), is(true));

        System.out.println("iGraphNode = " + iGraphNode);
        assertThat(visited.get(iGraphNode).hasVisited.value, is(true));
        assertEquals(2, (int) visited.get(iGraphNode).when.value);

        System.out.println("iGraphNode2 = " + iGraphNode2);
        assertThat(visited.get(iGraphNode2).hasVisited.value, is(true));
        assertEquals(3, (int) visited.get(iGraphNode2).when.value);
    }

    @Test
    public void testSearchMiddleRowNode() {
        final SimpleGraph simpleGraph = new GridGraphBuilder(50, 10).build();
        final IGraphSearch search = new GraphSearchBreadthFirst(simpleGraph);

        final IGraphNode node82 = new GridGraphNode(new GraphNode("82"));
        final Map<IGraphNode, HasVisitedAndWhen> visited = search.search(node82);

        assertThat(visited.size(), is(simpleGraph.edges.size()));
        assertThat(visited.values().stream().filter(x -> x.hasVisited.value).count(), is((long) simpleGraph.edges.size()));

        final Set<IGraphNode> neighbours = simpleGraph.neighbours(node82);
        assertThat(neighbours.size(), is(4));

        final ArrayList<IGraphNode> iGraphNodes = Lists.newArrayList(neighbours);
        final IGraphNode iGraphNode = iGraphNodes.get(0);
        final IGraphNode iGraphNode2 = iGraphNodes.get(1);
        final IGraphNode iGraphNode3 = iGraphNodes.get(2);
        final IGraphNode iGraphNode4 = iGraphNodes.get(3);

        assertThat(iGraphNode, is(new GridGraphNode(new GraphNode("81"), new PositionX(31), new PositionY(1))));
        assertThat(iGraphNode2, is(new GridGraphNode(new GraphNode("83"), new PositionX(33), new PositionY(1))));
        assertThat(iGraphNode3, is(new GridGraphNode(new GraphNode("32"), new PositionX(32), new PositionY(0))));
        assertThat(iGraphNode4, is(new GridGraphNode(new GraphNode("132"), new PositionX(32), new PositionY(2))));

        assertThat(visited.containsKey(iGraphNode), is(true));
        assertThat(visited.containsKey(iGraphNode2), is(true));
        assertThat(visited.containsKey(iGraphNode3), is(true));
        assertThat(visited.containsKey(iGraphNode4), is(true));

        System.out.println("iGraphNode = " + iGraphNode);
        assertThat(visited.get(iGraphNode).hasVisited.value, is(true));
        assertThat(visited.get(iGraphNode).when, is(new WhenVisited(2)));

        System.out.println("iGraphNode2 = " + iGraphNode2);
        assertThat(visited.get(iGraphNode2).hasVisited.value, is(true));
        assertThat(visited.get(iGraphNode2).when, is(new WhenVisited(3)));

        System.out.println("iGraphNode3 = " + iGraphNode3);
        assertThat(visited.get(iGraphNode3).hasVisited.value, is(true));
        assertThat(visited.get(iGraphNode3).when, is(new WhenVisited(4)));

        System.out.println("iGraphNode4 = " + iGraphNode4);
        assertThat(visited.get(iGraphNode4).hasVisited.value, is(true));
        assertThat(visited.get(iGraphNode4).when, is(new WhenVisited(5)));
    }

    @Test
    public void testSearchBottomLeftCornerNode() {
        final SimpleGraph simpleGraph = new GridGraphBuilder(50, 10).build();
        final IGraphSearch search = new GraphSearchBreadthFirst(simpleGraph);

        final IGraphNode node450 = new GridGraphNode(new GraphNode("450"));
        final Map<IGraphNode, HasVisitedAndWhen> visited = search.search(node450);

        assertThat(visited.size(), is(simpleGraph.edges.size()));
        assertThat(visited.values().stream().filter(x -> x.hasVisited.value).count(), is((long) simpleGraph.edges.size()));

        final Set<IGraphNode> neighbours = simpleGraph.neighbours(node450);
        assertThat(neighbours.size(), is(2));

        final ArrayList<IGraphNode> iGraphNodes = Lists.newArrayList(neighbours);
        final IGraphNode iGraphNode = iGraphNodes.get(0);
        final IGraphNode iGraphNode1 = iGraphNodes.get(1);

        assertThat(iGraphNode, is(new GridGraphNode(new GraphNode("451"), new PositionX(1), new PositionY(9))));
        assertThat(iGraphNode1, is(new GridGraphNode(new GraphNode("400"), new PositionX(0), new PositionY(8))));

        assertThat(visited.containsKey(iGraphNode), is(true));
        assertThat(visited.containsKey(iGraphNode1), is(true));

        System.out.println("iGraphNode = " + iGraphNode);
        assertThat(visited.get(iGraphNode).hasVisited.value, is(true));
        assertEquals(2, (int) visited.get(iGraphNode).when.value);

        System.out.println("iGraphNode1 = " + iGraphNode1);
        assertThat(visited.get(iGraphNode1).hasVisited.value, is(true));
        assertEquals(3, (int) visited.get(iGraphNode1).when.value);
    }

    @Test
    public void testSearchBottomRightCornerNode() {
        final SimpleGraph simpleGraph = new GridGraphBuilder(50, 10).build();
        final IGraphSearch search = new GraphSearchBreadthFirst(simpleGraph);

        final IGraphNode node499 = new GridGraphNode(new GraphNode("499"));
        final Map<IGraphNode, HasVisitedAndWhen> visited = search.search(node499);

        assertThat(visited.size(), is(simpleGraph.edges.size()));
        assertThat(visited.values().stream().filter(x -> x.hasVisited.value).count(), is((long) simpleGraph.edges.size()));

        final Set<IGraphNode> neighbours = simpleGraph.neighbours(node499);
        assertThat(neighbours.size(), is(2));

        final ArrayList<IGraphNode> iGraphNodes = Lists.newArrayList(neighbours);
        final IGraphNode iGraphNode = iGraphNodes.get(0);
        final IGraphNode iGraphNode2 = iGraphNodes.get(1);

        assertThat(iGraphNode, is(new GridGraphNode(new GraphNode("498"), new PositionX(48), new PositionY(9))));
        assertThat(iGraphNode2, is(new GridGraphNode(new GraphNode("449"), new PositionX(49), new PositionY(8))));

        assertThat(visited.containsKey(iGraphNode), is(true));
        assertThat(visited.containsKey(iGraphNode2), is(true));

        System.out.println("iGraphNode = " + iGraphNode);
        assertThat(visited.get(iGraphNode).hasVisited.value, is(true));
        assertEquals(2, (int) visited.get(iGraphNode).when.value);

        System.out.println("iGraphNode2 = " + iGraphNode2);
        assertThat(visited.get(iGraphNode2).hasVisited.value, is(true));
        assertEquals(3, (int) visited.get(iGraphNode2).when.value);
    }

    @Test
    public void testSearchBottomRowNode() {
        final SimpleGraph simpleGraph = new GridGraphBuilder(50, 10).build();
        final IGraphSearch search = new GraphSearchBreadthFirst(simpleGraph);

        final IGraphNode node475 = new GridGraphNode(new GraphNode("475"));
        final Map<IGraphNode, HasVisitedAndWhen> visited = search.search(node475);

        assertThat(visited.size(), is(simpleGraph.edges.size()));
        assertThat(visited.values().stream().filter(x -> x.hasVisited.value).count(), is((long) simpleGraph.edges.size()));

        final Set<IGraphNode> neighbours = simpleGraph.neighbours(node475);
        assertThat(neighbours.size(), is(3));

        final ArrayList<IGraphNode> iGraphNodes = Lists.newArrayList(neighbours);
        final IGraphNode iGraphNode = iGraphNodes.get(0);
        final IGraphNode iGraphNode2 = iGraphNodes.get(1);
        final IGraphNode iGraphNode3 = iGraphNodes.get(2);

        assertThat(iGraphNode, is(new GridGraphNode(new GraphNode("474"), new PositionX(25), new PositionY(9))));
        assertThat(iGraphNode2, is(new GridGraphNode(new GraphNode("476"), new PositionX(27), new PositionY(9))));
        assertThat(iGraphNode3, is(new GridGraphNode(new GraphNode("425"), new PositionX(26), new PositionY(8))));

        assertThat(visited.containsKey(iGraphNode), is(true));
        assertThat(visited.containsKey(iGraphNode2), is(true));
        assertThat(visited.containsKey(iGraphNode3), is(true));

        System.out.println("iGraphNode = " + iGraphNode);
        assertThat(visited.get(iGraphNode).hasVisited.value, is(true));
        assertEquals(2, (int) visited.get(iGraphNode).when.value);

        System.out.println("iGraphNode2 = " + iGraphNode2);
        assertThat(visited.get(iGraphNode2).hasVisited.value, is(true));
        assertEquals(3, (int) visited.get(iGraphNode2).when.value);

        System.out.println("iGraphNode3 = " + iGraphNode3);
        assertThat(visited.get(iGraphNode3).hasVisited.value, is(true));
        assertEquals(4, (int) visited.get(iGraphNode3).when.value);
    }


}