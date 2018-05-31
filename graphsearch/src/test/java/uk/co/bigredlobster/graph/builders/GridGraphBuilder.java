package uk.co.bigredlobster.graph.builders;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import uk.co.bigredlobster.graph.GridGraph;
import uk.co.bigredlobster.graph.IGraph;
import uk.co.bigredlobster.graph.nodes.GraphNode;
import uk.co.bigredlobster.graph.nodes.GridGraphNode;
import uk.co.bigredlobster.graph.nodes.IGraphNode;
import uk.co.bigredlobster.graph.nodes.factory.INodeFactory;
import uk.co.bigredlobster.graph.nodes.factory.NodeFactory;
import uk.co.bigredlobster.microtypes.NodeName;
import uk.co.bigredlobster.microtypes.PositionX;
import uk.co.bigredlobster.microtypes.PositionY;

public class GridGraphBuilder {

    private final INodeFactory factory = new NodeFactory();
    private final int width;
    private final int height;

    public GridGraphBuilder(final int width, final int height) {
        this.width = width;
        this.height = height;
    }

    private boolean inBounds(final int x, final int y) {
        return x >= 0 && x < width && y >= 0 && y < height;
    }

    public IGraph build() {
        final ImmutableMap.Builder<IGraphNode, ImmutableSet<IGraphNode>> builder = ImmutableMap.builder();

        int nodeName = 0;
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                ImmutableSet.Builder<IGraphNode> possibleNeighbours = ImmutableSet.builder();
                if (inBounds(x - 1, y)) {
                    final IGraphNode newNode = new GridGraphNode(new GraphNode(getNodeName(x - 1, y)), new PositionX(x - 1), new PositionY(y));
                    possibleNeighbours.add(factory.createOrGet(newNode));
                }
                if (inBounds(x + 1, y)) {
                    final IGraphNode newNode = new GridGraphNode(new GraphNode(getNodeName(x + 1, y)), new PositionX(x + 1), new PositionY(y));
                    possibleNeighbours.add(factory.createOrGet(newNode));
                }
                if (inBounds(x, y - 1)) {
                    final IGraphNode newNode = new GridGraphNode(new GraphNode(getNodeName(x, y - 1)), new PositionX(x), new PositionY(y - 1));
                    possibleNeighbours.add(factory.createOrGet(newNode));
                }
                if (inBounds(x, y + 1)) {
                    final IGraphNode newNode = new GridGraphNode(new GraphNode(getNodeName(x, y + 1)), new PositionX(x), new PositionY(y + 1));
                    possibleNeighbours.add(factory.createOrGet(newNode));
                }
                builder.put(
                        new GridGraphNode(
                                new GraphNode(new NodeName(nodeName + "")),
                                new PositionX(x),
                                new PositionY(y)),
                        possibleNeighbours.build()
                );

                nodeName++;

                if (x % 10 == 0) {
                    System.out.println("GridGraphBuilder nodeName=" + nodeName + " x=" + x + " y=" + y);
                }
            }
        }

        return new GridGraph(builder.build());
    }

    private NodeName getNodeName(int x, int y) {
        return new NodeName(y * width + x + "");
    }
}
