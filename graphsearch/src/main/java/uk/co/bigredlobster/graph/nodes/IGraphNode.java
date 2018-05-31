package uk.co.bigredlobster.graph.nodes;

import java.util.Set;

public interface IGraphNode {
    Set<IGraphNode> getNeighbours();

    String getName();
}
