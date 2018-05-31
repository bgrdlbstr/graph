package uk.co.bigredlobster.graph.builders;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import uk.co.bigredlobster.graph.SimpleGraph;
import uk.co.bigredlobster.graph.nodes.basic.GraphNode;
import uk.co.bigredlobster.graph.nodes.IGraphNode;
import uk.co.bigredlobster.graph.nodes.factory.INodeFactory;
import uk.co.bigredlobster.graph.nodes.factory.NodeFactory;

public class SimpleGraphBuilder {

    private final INodeFactory factory = new NodeFactory();

    public SimpleGraph build() {

        final ImmutableMap.Builder<IGraphNode, ImmutableSet<IGraphNode>> builder = ImmutableMap.builder();

        buildTopRow(0, builder);

        buildMiddleRow(10, builder);
        buildMiddleRow(20, builder);
        buildMiddleRow(30, builder);
        buildMiddleRow(40, builder);
        buildMiddleRow(50, builder);
        buildMiddleRow(60, builder);
        buildMiddleRow(70, builder);
        buildMiddleRow(80, builder);

        buildBottomRow(90, builder);

        return new SimpleGraph(builder.build());
    }

    @SuppressWarnings("SameParameterValue")
    private void buildTopRow(int seed, ImmutableMap.Builder<IGraphNode, ImmutableSet<IGraphNode>> builder) {
        int nodeName = seed;

        builder.put(factory.createOrGet(new GraphNode(++nodeName + "")), ImmutableSet.of(
                factory.createOrGet(new GraphNode(nodeName + 1 + "")),
                factory.createOrGet(new GraphNode(nodeName + 9 + ""))));
        builder.put(factory.createOrGet(new GraphNode(++nodeName + "")), ImmutableSet.of(
                factory.createOrGet(new GraphNode(nodeName - 1 + "")),
                factory.createOrGet(new GraphNode(nodeName + 1 + "")),
                factory.createOrGet(new GraphNode(nodeName + 9 + ""))));
        builder.put(factory.createOrGet(new GraphNode(++nodeName + "")), ImmutableSet.of(
                factory.createOrGet(new GraphNode(nodeName - 1 + "")),
                factory.createOrGet(new GraphNode(nodeName + 1 + "")),
                factory.createOrGet(new GraphNode(nodeName + 9 + ""))));
        builder.put(factory.createOrGet(new GraphNode(++nodeName + "")), ImmutableSet.of(
                factory.createOrGet(new GraphNode(nodeName - 1 + "")),
                factory.createOrGet(new GraphNode(nodeName + 1 + "")),
                factory.createOrGet(new GraphNode(nodeName + 9 + ""))));
        builder.put(factory.createOrGet(new GraphNode(++nodeName + "")), ImmutableSet.of(
                factory.createOrGet(new GraphNode(nodeName - 1 + "")),
                factory.createOrGet(new GraphNode(nodeName + 1 + "")),
                factory.createOrGet(new GraphNode(nodeName + 9 + ""))));
        builder.put(factory.createOrGet(new GraphNode(++nodeName + "")), ImmutableSet.of(
                factory.createOrGet(new GraphNode(nodeName - 1 + "")),
                factory.createOrGet(new GraphNode(nodeName + 1 + "")),
                factory.createOrGet(new GraphNode(nodeName + 9 + ""))));
        builder.put(factory.createOrGet(new GraphNode(++nodeName + "")), ImmutableSet.of(
                factory.createOrGet(new GraphNode(nodeName - 1 + "")),
                factory.createOrGet(new GraphNode(nodeName + 1 + "")),
                factory.createOrGet(new GraphNode(nodeName + 9 + ""))));
        builder.put(factory.createOrGet(new GraphNode(++nodeName + "")), ImmutableSet.of(
                factory.createOrGet(new GraphNode(nodeName - 1 + "")),
                factory.createOrGet(new GraphNode(nodeName + 1 + "")),
                factory.createOrGet(new GraphNode(nodeName + 9 + ""))));
        builder.put(factory.createOrGet(new GraphNode(++nodeName + "")), ImmutableSet.of(
                factory.createOrGet(new GraphNode(nodeName - 1 + "")),
                factory.createOrGet(new GraphNode(nodeName + 1 + "")),
                factory.createOrGet(new GraphNode(nodeName + 9 + ""))));
        builder.put(factory.createOrGet(new GraphNode(++nodeName + "")), ImmutableSet.of(
                factory.createOrGet(new GraphNode(nodeName - 1 + "")),
                factory.createOrGet(new GraphNode(nodeName + 9 + ""))));
    }

    @SuppressWarnings("SameParameterValue")
    private void buildBottomRow(int seed, ImmutableMap.Builder<IGraphNode, ImmutableSet<IGraphNode>> builder) {
        int nodeName = seed;
        builder.put(factory.createOrGet(new GraphNode(++nodeName + "")), ImmutableSet.of(
                factory.createOrGet(new GraphNode(nodeName - 10 + "")),
                factory.createOrGet(new GraphNode(nodeName + 1 + ""))));
        builder.put(factory.createOrGet(new GraphNode(++nodeName + "")), ImmutableSet.of(
                factory.createOrGet(new GraphNode(nodeName - 1 + "")),
                factory.createOrGet(new GraphNode(nodeName - 10 + "")),
                factory.createOrGet(new GraphNode(nodeName + 1 + ""))));
        builder.put(factory.createOrGet(new GraphNode(++nodeName + "")), ImmutableSet.of(
                factory.createOrGet(new GraphNode(nodeName - 1 + "")),
                factory.createOrGet(new GraphNode(nodeName - 10 + "")),
                factory.createOrGet(new GraphNode(nodeName + 1 + ""))));
        builder.put(factory.createOrGet(new GraphNode(++nodeName + "")), ImmutableSet.of(
                factory.createOrGet(new GraphNode(nodeName - 1 + "")),
                factory.createOrGet(new GraphNode(nodeName - 10 + "")),
                factory.createOrGet(new GraphNode(nodeName + 1 + ""))));
        builder.put(factory.createOrGet(new GraphNode(++nodeName + "")), ImmutableSet.of(
                factory.createOrGet(new GraphNode(nodeName - 1 + "")),
                factory.createOrGet(new GraphNode(nodeName - 10 + "")),
                factory.createOrGet(new GraphNode(nodeName + 1 + ""))));
        builder.put(factory.createOrGet(new GraphNode(++nodeName + "")), ImmutableSet.of(
                factory.createOrGet(new GraphNode(nodeName - 1 + "")),
                factory.createOrGet(new GraphNode(nodeName - 10 + "")),
                factory.createOrGet(new GraphNode(nodeName + 1 + ""))));
        builder.put(factory.createOrGet(new GraphNode(++nodeName + "")), ImmutableSet.of(
                factory.createOrGet(new GraphNode(nodeName - 1 + "")),
                factory.createOrGet(new GraphNode(nodeName - 10 + "")),
                factory.createOrGet(new GraphNode(nodeName + 1 + ""))));
        builder.put(factory.createOrGet(new GraphNode(++nodeName + "")), ImmutableSet.of(
                factory.createOrGet(new GraphNode(nodeName - 1 + "")),
                factory.createOrGet(new GraphNode(nodeName - 10 + "")),
                factory.createOrGet(new GraphNode(nodeName + 1 + ""))));
        builder.put(factory.createOrGet(new GraphNode(++nodeName + "")), ImmutableSet.of(
                factory.createOrGet(new GraphNode(nodeName - 1 + "")),
                factory.createOrGet(new GraphNode(nodeName - 10 + "")),
                factory.createOrGet(new GraphNode(nodeName + 1 + ""))));
        builder.put(factory.createOrGet(new GraphNode(++nodeName + "")), ImmutableSet.of(
                factory.createOrGet(new GraphNode(nodeName - 1 + "")),
                factory.createOrGet(new GraphNode(nodeName - 10 + ""))));

    }

    private void buildMiddleRow(int seed, ImmutableMap.Builder<IGraphNode, ImmutableSet<IGraphNode>> builder) {
        int nodeName = seed;
        builder.put(factory.createOrGet(new GraphNode(++nodeName + "")), ImmutableSet.of(
                factory.createOrGet(new GraphNode(nodeName - 10 + "")),
                factory.createOrGet(new GraphNode(nodeName + 1 + "")),
                factory.createOrGet(new GraphNode(nodeName + 9 + ""))));
        builder.put(factory.createOrGet(new GraphNode(++nodeName + "")), ImmutableSet.of(
                factory.createOrGet(new GraphNode(nodeName - 1 + "")),
                factory.createOrGet(new GraphNode(nodeName - 10 + "")),
                factory.createOrGet(new GraphNode(nodeName + 1 + "")),
                factory.createOrGet(new GraphNode(nodeName + 9 + ""))));
        builder.put(factory.createOrGet(new GraphNode(++nodeName + "")), ImmutableSet.of(
                factory.createOrGet(new GraphNode(nodeName - 1 + "")),
                factory.createOrGet(new GraphNode(nodeName - 10 + "")),
                factory.createOrGet(new GraphNode(nodeName + 1 + "")),
                factory.createOrGet(new GraphNode(nodeName + 9 + ""))));
        builder.put(factory.createOrGet(new GraphNode(++nodeName + "")), ImmutableSet.of(
                factory.createOrGet(new GraphNode(nodeName - 1 + "")),
                factory.createOrGet(new GraphNode(nodeName - 10 + "")),
                factory.createOrGet(new GraphNode(nodeName + 1 + "")),
                factory.createOrGet(new GraphNode(nodeName + 9 + ""))));
        builder.put(factory.createOrGet(new GraphNode(++nodeName + "")), ImmutableSet.of(
                factory.createOrGet(new GraphNode(nodeName - 1 + "")),
                factory.createOrGet(new GraphNode(nodeName - 10 + "")),
                factory.createOrGet(new GraphNode(nodeName + 1 + "")),
                factory.createOrGet(new GraphNode(nodeName + 9 + ""))));
        builder.put(factory.createOrGet(new GraphNode(++nodeName + "")), ImmutableSet.of(
                factory.createOrGet(new GraphNode(nodeName - 1 + "")),
                factory.createOrGet(new GraphNode(nodeName - 10 + "")),
                factory.createOrGet(new GraphNode(nodeName + 1 + "")),
                factory.createOrGet(new GraphNode(nodeName + 9 + ""))));
        builder.put(factory.createOrGet(new GraphNode(++nodeName + "")), ImmutableSet.of(
                factory.createOrGet(new GraphNode(nodeName - 1 + "")),
                factory.createOrGet(new GraphNode(nodeName - 10 + "")),
                factory.createOrGet(new GraphNode(nodeName + 1 + "")),
                factory.createOrGet(new GraphNode(nodeName + 9 + ""))));
        builder.put(factory.createOrGet(new GraphNode(++nodeName + "")), ImmutableSet.of(
                factory.createOrGet(new GraphNode(nodeName - 1 + "")),
                factory.createOrGet(new GraphNode(nodeName - 10 + "")),
                factory.createOrGet(new GraphNode(nodeName + 1 + "")),
                factory.createOrGet(new GraphNode(nodeName + 9 + ""))));
        builder.put(factory.createOrGet(new GraphNode(++nodeName + "")), ImmutableSet.of(
                factory.createOrGet(new GraphNode(nodeName - 1 + "")),
                factory.createOrGet(new GraphNode(nodeName - 10 + "")),
                factory.createOrGet(new GraphNode(nodeName + 1 + "")),
                factory.createOrGet(new GraphNode(nodeName + 9 + ""))));
        builder.put(factory.createOrGet(new GraphNode(++nodeName + "")), ImmutableSet.of(
                factory.createOrGet(new GraphNode(nodeName - 1 + "")),
                factory.createOrGet(new GraphNode(nodeName - 10 + "")),
                factory.createOrGet(new GraphNode(nodeName + 9 + ""))));
    }

}
