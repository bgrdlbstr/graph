package uk.co.bigredlobster.homegrownGraph.graphs;

import uk.co.bigredlobster.homegrownGraph.IGraph;

public interface IGraphBuilderBoundsChecker {
    boolean inBounds(final int x, final int y);
    IGraph build();
}
