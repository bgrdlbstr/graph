package uk.co.bigredlobster.graph.nodes;

import java.util.LinkedList;
import java.util.List;

public class NodeFactory implements INodeFactory {

    private final List<IGraphNode> nodes;

    public NodeFactory() {
        nodes = new LinkedList<>();
    }

    @Override
    public IGraphNode createOrGet(IGraphNode node) {
        if(!nodes.contains(node))
            nodes.add(node);
        return node;
    }

}
