package uk.co.bigredlobster.graph;

import org.junit.Test;
import uk.co.bigredlobster.graph.nodes.GraphNode;
import uk.co.bigredlobster.graph.searchAlgos.GraphSearchBreadthFirst;
import uk.co.bigredlobster.graph.searchAlgos.IGraphSearch;
import uk.co.bigredlobster.microtypes.HasVisited;

import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class SimpleGraphSearchBreadthFirstTest {

    @Test
    public void testSearch() {
        final SimpleGraph simpleGraph = new SimpleGraphBuilder().build();
        final IGraphSearch search = new GraphSearchBreadthFirst(simpleGraph);
        final Map<GraphNode, HasVisited> visited = search.search(simpleGraph.edges.get(new GraphNode("4")).asList().get(0));
        assertThat(visited.size(), is(simpleGraph.edges.size()));
        assertThat(visited.values().stream().filter(x -> x.value).count(), is((long) simpleGraph.edges.size()));
    }

}