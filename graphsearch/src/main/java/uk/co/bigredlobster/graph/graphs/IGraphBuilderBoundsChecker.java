package uk.co.bigredlobster.graph.graphs;

import uk.co.bigredlobster.graph.IGraph;

public interface IGraphBuilderBoundsChecker {
    boolean inBounds(final int x, final int y);
    IGraph build();
}
