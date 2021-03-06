package uk.co.bigredlobster.homegrownGraph.builders;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import uk.co.bigredlobster.homegrownGraph.IGraph;
import uk.co.bigredlobster.homegrownGraph.graphs.GraphFactory;
import uk.co.bigredlobster.homegrownGraph.nodes.GraphNode;
import uk.co.bigredlobster.homegrownGraph.nodes.IGraphNode;
import uk.co.bigredlobster.homegrownGraph.nodes.factory.INodeFactory;
import uk.co.bigredlobster.homegrownGraph.nodes.factory.NodeFactory;
import uk.co.bigredlobster.microtypes.NodeName;

public class SimpleGraphBuilder {

    private final INodeFactory factory = new NodeFactory();

    public IGraph build() {

        final ImmutableMap.Builder<IGraphNode, ImmutableSet<IGraphNode>> builder = ImmutableMap.builder();

        builder.put(factory.createOrGet(new GraphNode(new NodeName("A"))), ImmutableSet.of(
                factory.createOrGet(new GraphNode(new NodeName("B")))));

        builder.put(factory.createOrGet(new GraphNode(new NodeName("B"))), ImmutableSet.of(
                factory.createOrGet(new GraphNode(new NodeName("A"))),
                factory.createOrGet(new GraphNode(new NodeName("C"))),
                factory.createOrGet(new GraphNode(new NodeName("D")))
        ));

        builder.put(factory.createOrGet(new GraphNode(new NodeName("C"))), ImmutableSet.of(
                factory.createOrGet(new GraphNode(new NodeName("B"))),
                factory.createOrGet(new GraphNode(new NodeName("D"))),
                factory.createOrGet(new GraphNode(new NodeName("E")))
        ));

        builder.put(factory.createOrGet(new GraphNode(new NodeName("D"))), ImmutableSet.of(
                factory.createOrGet(new GraphNode(new NodeName("B"))),
                factory.createOrGet(new GraphNode(new NodeName("C")))
        ));

        builder.put(factory.createOrGet(new GraphNode(new NodeName("E"))), ImmutableSet.of(
                factory.createOrGet(new GraphNode(new NodeName("C")))
        ));

        return GraphFactory.getSimpleGraph(builder.build());
    }
}
