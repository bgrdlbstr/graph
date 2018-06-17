package uk.co.bigredlobster.homegrownGraph.nodes;

import uk.co.bigredlobster.microtypes.NodeName;

import java.util.Set;

public interface IGraphNode {
    Set<IGraphNode> getNeighbours();

    NodeName getName();
}
