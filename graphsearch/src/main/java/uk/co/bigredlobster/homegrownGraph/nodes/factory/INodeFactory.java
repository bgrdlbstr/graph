package uk.co.bigredlobster.homegrownGraph.nodes.factory;

import uk.co.bigredlobster.homegrownGraph.nodes.IGraphNode;

public interface INodeFactory {
    IGraphNode createOrGet(IGraphNode node);
}
