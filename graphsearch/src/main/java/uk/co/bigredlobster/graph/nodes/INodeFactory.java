package uk.co.bigredlobster.graph.nodes;

public interface INodeFactory {
    IGraphNode createOrGet(IGraphNode node);
}
