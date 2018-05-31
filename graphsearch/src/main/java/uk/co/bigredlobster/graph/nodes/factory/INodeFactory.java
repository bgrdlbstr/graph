package uk.co.bigredlobster.graph.nodes.factory;

import uk.co.bigredlobster.graph.nodes.IGraphNode;

public interface INodeFactory {
    IGraphNode createOrGet(IGraphNode node);
}
