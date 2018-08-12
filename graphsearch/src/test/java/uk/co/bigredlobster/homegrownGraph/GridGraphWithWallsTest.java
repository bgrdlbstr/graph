package uk.co.bigredlobster.homegrownGraph;

import org.junit.Test;
import uk.co.bigredlobster.homegrownGraph.graphs.GraphFactory;
import uk.co.bigredlobster.homegrownGraph.nodes.GraphNode;
import uk.co.bigredlobster.homegrownGraph.nodes.GridGraphNode;
import uk.co.bigredlobster.homegrownGraph.nodes.IGraphNode;
import uk.co.bigredlobster.microtypes.NodeName;
import uk.co.bigredlobster.microtypes.PositionX;
import uk.co.bigredlobster.microtypes.PositionY;

import java.util.ArrayList;
import java.util.Set;

import static com.google.common.collect.Lists.newArrayList;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static uk.co.bigredlobster.TestWalls.walls1;

public class GridGraphWithWallsTest {

    @Test
    public void testNodeLeftOfWall() {
        final IGraph simpleGraph = GraphFactory.getGridGraphWithWalls(50, 10, walls1);

        final IGraphNode node = new GridGraphNode(new GraphNode(new NodeName("259")));
        final Set<IGraphNode> neighbours = simpleGraph.edges().get(node);

        assertThat(neighbours.size(), is(3));

        final ArrayList<IGraphNode> iGraphNodes = newArrayList(neighbours);
        final IGraphNode iGraphNode = iGraphNodes.get(0);
        final IGraphNode iGraphNode2 = iGraphNodes.get(1);
        final IGraphNode iGraphNode3 = iGraphNodes.get(2);

        assertThat(iGraphNode, is(new GridGraphNode(new GraphNode(new NodeName("258")), new PositionX(8), new PositionY(5))));
        assertThat(iGraphNode2, is(new GridGraphNode(new GraphNode(new NodeName("209")), new PositionX(9), new PositionY(4))));
        assertThat(iGraphNode3, is(new GridGraphNode(new GraphNode(new NodeName("309")), new PositionX(9), new PositionY(6))));
    }

    @Test
    public void testNodeRightOfWall() {
        final IGraph simpleGraph = GraphFactory.getGridGraphWithWalls(50, 10, walls1);

        final IGraphNode node = new GridGraphNode(new GraphNode(new NodeName("262")));
        final Set<IGraphNode> neighbours = simpleGraph.edges().get(node);

        assertThat(neighbours.size(), is(3));

        final ArrayList<IGraphNode> iGraphNodes = newArrayList(neighbours);
        final IGraphNode iGraphNode = iGraphNodes.get(0);
        final IGraphNode iGraphNode2 = iGraphNodes.get(1);
        final IGraphNode iGraphNode3 = iGraphNodes.get(2);

        assertThat(iGraphNode, is(new GridGraphNode(new GraphNode(new NodeName("263")), new PositionX(13), new PositionY(5))));
        assertThat(iGraphNode2, is(new GridGraphNode(new GraphNode(new NodeName("212")), new PositionX(12), new PositionY(4))));
        assertThat(iGraphNode3, is(new GridGraphNode(new GraphNode(new NodeName("312")), new PositionX(12), new PositionY(6))));
    }

}