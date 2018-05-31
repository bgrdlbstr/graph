package uk.co.bigredlobster.graph.builders;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import uk.co.bigredlobster.graph.SimpleGraph;
import uk.co.bigredlobster.graph.nodes.IGraphNode;
import uk.co.bigredlobster.graph.nodes.basic.GraphNode;
import uk.co.bigredlobster.graph.nodes.factory.INodeFactory;
import uk.co.bigredlobster.graph.nodes.factory.NodeFactory;

public class SimpleGraphBuilder {

    private final INodeFactory factory = new NodeFactory();

    public SimpleGraph build() {

        final ImmutableMap.Builder<IGraphNode, ImmutableSet<IGraphNode>> builder = ImmutableMap.builder();

        builder.put(factory.createOrGet(new GraphNode("A")), ImmutableSet.of(
                factory.createOrGet(new GraphNode("B"))));

        builder.put(factory.createOrGet(new GraphNode("B")), ImmutableSet.of(
                factory.createOrGet(new GraphNode("A")),
                factory.createOrGet(new GraphNode("C")),
                factory.createOrGet(new GraphNode("D"))
        ));

        builder.put(factory.createOrGet(new GraphNode("C")), ImmutableSet.of(
                factory.createOrGet(new GraphNode("B")),
                factory.createOrGet(new GraphNode("D")),
                factory.createOrGet(new GraphNode("E"))
        ));

        builder.put(factory.createOrGet(new GraphNode("D")), ImmutableSet.of(
                factory.createOrGet(new GraphNode("B")),
                factory.createOrGet(new GraphNode("C"))
        ));

        builder.put(factory.createOrGet(new GraphNode("E")), ImmutableSet.of(
                factory.createOrGet(new GraphNode("C"))
        ));

        return new SimpleGraph(builder.build());
    }
}
