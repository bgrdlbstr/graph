package uk.co.bigredlobster.graph.nodes;

import java.util.LinkedList;
import java.util.List;

public class NodeFactory {

    private final List<GraphNode> nodes;

    public NodeFactory() {
        nodes = new LinkedList<>();
    }

    public GraphNode createOrGet(GraphNode node) {
        if(!nodes.contains(node)) {
            nodes.add(node);
        }
        return node;
    }

}
