package uk.co.bigredlobster.graph.nodes;

import uk.co.bigredlobster.microtypes.NodeName;

import java.util.Set;

public interface IGraphNode {
    Set<IGraphNode> getNeighbours();

    NodeName getName();
}
