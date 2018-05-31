package uk.co.bigredlobster.graph;

import com.google.common.collect.Lists;
import org.junit.Test;
import uk.co.bigredlobster.graph.builders.SimpleGraphBuilder;
import uk.co.bigredlobster.graph.nodes.IGraphNode;
import uk.co.bigredlobster.graph.nodes.GraphNode;
import uk.co.bigredlobster.graph.searchAlgos.GraphSearchBreadthFirst;
import uk.co.bigredlobster.graph.searchAlgos.IGraphSearch;
import uk.co.bigredlobster.microtypes.HasVisitedAndWhen;
import uk.co.bigredlobster.microtypes.NodeName;
import uk.co.bigredlobster.microtypes.WhenVisited;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class SimpleGraphSearchBreadthFirstTest {

    @Test
    public void testSearchA() {
        final SimpleGraph simpleGraph = new SimpleGraphBuilder().build();
        final IGraphSearch search = new GraphSearchBreadthFirst(simpleGraph);

        final IGraphNode nodeA = new GraphNode(new NodeName("A"));
        final Map<IGraphNode, HasVisitedAndWhen> visited = search.search(nodeA);

        assertThat(visited.size(), is(simpleGraph.edges().size()));
        assertThat(visited.values().stream().filter(x -> x.hasVisited.value).count(), is((long) simpleGraph.edges().size()));

        final Set<IGraphNode> neighbours = simpleGraph.neighbours(nodeA);
        assertThat(neighbours.size(), is(1));

        final ArrayList<IGraphNode> iGraphNodes = Lists.newArrayList(neighbours);

        final IGraphNode iGraphNode = iGraphNodes.get(0);
        assertThat(iGraphNode, is(new GraphNode(new NodeName("B"))));
        assertThat(visited.containsKey(iGraphNode), is(true));

        System.out.println("iGraphNode = " + iGraphNode);
        assertThat(visited.get(iGraphNode).hasVisited.value, is(true));
        assertThat(visited.get(iGraphNode).when, is(new WhenVisited(2)));
    }

    @Test
    public void testSearchB() {
        final SimpleGraph simpleGraph = new SimpleGraphBuilder().build();
        final IGraphSearch search = new GraphSearchBreadthFirst(simpleGraph);

        final IGraphNode nodeB = new GraphNode(new NodeName("B"));
        final Map<IGraphNode, HasVisitedAndWhen> visited = search.search(nodeB);

        assertThat(visited.size(), is(simpleGraph.edges().size()));
        assertThat(visited.values().stream().filter(x -> x.hasVisited.value).count(), is((long) simpleGraph.edges().size()));

        final Set<IGraphNode> neighbours = simpleGraph.neighbours(nodeB);
        assertThat(neighbours.size(), is(3));

        final ArrayList<IGraphNode> iGraphNodes = Lists.newArrayList(neighbours);

        final IGraphNode iGraphNode = iGraphNodes.get(0);
        final IGraphNode iGraphNode2 = iGraphNodes.get(1);
        final IGraphNode iGraphNode3 = iGraphNodes.get(2);

        System.out.println("iGraphNode = " + iGraphNode);
        assertThat(iGraphNode, is(new GraphNode(new NodeName("A"))));
        assertThat(visited.containsKey(iGraphNode), is(true));
        assertThat(visited.get(iGraphNode).hasVisited.value, is(true));
        assertThat(visited.get(iGraphNode).when, is(new WhenVisited(2)));

        System.out.println("iGraphNode2 = " + iGraphNode2);
        assertThat(iGraphNode2, is(new GraphNode(new NodeName("C"))));
        assertThat(visited.containsKey(iGraphNode2), is(true));
        assertThat(visited.get(iGraphNode2).hasVisited.value, is(true));
        assertThat(visited.get(iGraphNode2).when, is(new WhenVisited(3)));

        System.out.println("iGraphNode3 = " + iGraphNode3);
        assertThat(iGraphNode3, is(new GraphNode(new NodeName("D"))));
        assertThat(visited.containsKey(iGraphNode3), is(true));
        assertThat(visited.get(iGraphNode3).hasVisited.value, is(true));
        assertThat(visited.get(iGraphNode3).when, is(new WhenVisited(4)));
    }

    @Test
    public void testSearchC() {
        final SimpleGraph simpleGraph = new SimpleGraphBuilder().build();
        final IGraphSearch search = new GraphSearchBreadthFirst(simpleGraph);

        final IGraphNode nodeC = new GraphNode(new NodeName("C"));
        final Map<IGraphNode, HasVisitedAndWhen> visited = search.search(nodeC);

        assertThat(visited.size(), is(simpleGraph.edges().size()));
        assertThat(visited.values().stream().filter(x -> x.hasVisited.value).count(), is((long) simpleGraph.edges().size()));

        final Set<IGraphNode> neighbours = simpleGraph.neighbours(nodeC);
        assertThat(neighbours.size(), is(3));

        final ArrayList<IGraphNode> iGraphNodes = Lists.newArrayList(neighbours);

        final IGraphNode iGraphNode = iGraphNodes.get(0);
        final IGraphNode iGraphNode2 = iGraphNodes.get(1);
        final IGraphNode iGraphNode3 = iGraphNodes.get(2);

        System.out.println("iGraphNode = " + iGraphNode);
        assertThat(iGraphNode, is(new GraphNode(new NodeName("B"))));
        assertThat(visited.containsKey(iGraphNode), is(true));
        assertThat(visited.get(iGraphNode).hasVisited.value, is(true));
        assertThat(visited.get(iGraphNode).when, is(new WhenVisited(2)));

        System.out.println("iGraphNode2 = " + iGraphNode2);
        assertThat(iGraphNode2, is(new GraphNode(new NodeName("D"))));
        assertThat(visited.containsKey(iGraphNode2), is(true));
        assertThat(visited.get(iGraphNode2).hasVisited.value, is(true));
        assertThat(visited.get(iGraphNode2).when, is(new WhenVisited(3)));

        System.out.println("iGraphNode3 = " + iGraphNode3);
        assertThat(iGraphNode3, is(new GraphNode(new NodeName("E"))));
        assertThat(visited.containsKey(iGraphNode3), is(true));
        assertThat(visited.get(iGraphNode3).hasVisited.value, is(true));
        assertThat(visited.get(iGraphNode3).when, is(new WhenVisited(4)));
    }

    @Test
    public void testSearchD() {
        final SimpleGraph simpleGraph = new SimpleGraphBuilder().build();
        final IGraphSearch search = new GraphSearchBreadthFirst(simpleGraph);

        final IGraphNode nodeD = new GraphNode(new NodeName("D"));
        final Map<IGraphNode, HasVisitedAndWhen> visited = search.search(nodeD);

        assertThat(visited.size(), is(simpleGraph.edges().size()));
        assertThat(visited.values().stream().filter(x -> x.hasVisited.value).count(), is((long) simpleGraph.edges().size()));

        final Set<IGraphNode> neighbours = simpleGraph.neighbours(nodeD);
        assertThat(neighbours.size(), is(2));

        final ArrayList<IGraphNode> iGraphNodes = Lists.newArrayList(neighbours);

        final IGraphNode iGraphNode = iGraphNodes.get(0);
        final IGraphNode iGraphNode2 = iGraphNodes.get(1);

        System.out.println("iGraphNode = " + iGraphNode);
        assertThat(iGraphNode, is(new GraphNode(new NodeName("B"))));
        assertThat(visited.containsKey(iGraphNode), is(true));
        assertThat(visited.get(iGraphNode).hasVisited.value, is(true));
        assertThat(visited.get(iGraphNode).when, is(new WhenVisited(2)));

        System.out.println("iGraphNode2 = " + iGraphNode2);
        assertThat(iGraphNode2, is(new GraphNode(new NodeName("C"))));
        assertThat(visited.containsKey(iGraphNode2), is(true));
        assertThat(visited.get(iGraphNode2).hasVisited.value, is(true));
        assertThat(visited.get(iGraphNode2).when, is(new WhenVisited(3)));
    }

    @Test
    public void testSearchE() {
        final SimpleGraph simpleGraph = new SimpleGraphBuilder().build();
        final IGraphSearch search = new GraphSearchBreadthFirst(simpleGraph);

        final IGraphNode nodeD = new GraphNode(new NodeName("E"));
        final Map<IGraphNode, HasVisitedAndWhen> visited = search.search(nodeD);

        assertThat(visited.size(), is(simpleGraph.edges().size()));
        assertThat(visited.values().stream().filter(x -> x.hasVisited.value).count(), is((long) simpleGraph.edges().size()));

        final Set<IGraphNode> neighbours = simpleGraph.neighbours(nodeD);
        assertThat(neighbours.size(), is(1));

        final ArrayList<IGraphNode> iGraphNodes = Lists.newArrayList(neighbours);

        final IGraphNode iGraphNode = iGraphNodes.get(0);

        System.out.println("iGraphNode = " + iGraphNode);
        assertThat(iGraphNode, is(new GraphNode(new NodeName("C"))));
        assertThat(visited.containsKey(iGraphNode), is(true));
        assertThat(visited.get(iGraphNode).hasVisited.value, is(true));
        assertThat(visited.get(iGraphNode).when, is(new WhenVisited(2)));
    }
}