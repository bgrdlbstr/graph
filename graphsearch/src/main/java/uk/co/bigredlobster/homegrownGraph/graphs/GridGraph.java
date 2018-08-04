package uk.co.bigredlobster.homegrownGraph.graphs;

import uk.co.bigredlobster.homegrownGraph.IGraph;

class GridGraph extends ForwardingGraph implements IGraph {
    GridGraph(final IGraph graph) {
        super(graph);
    }

    static class Builder extends BuilderBase {

        Builder(final int width, final int height) {
            super(width, height);
        }

        @Override
        public boolean inBounds(final int x, final int y) {
            return x >= 0 && x < width && y >= 0 && y < height;
        }

        @Override
        public IGraph build() {
            return super.build();
        }
    }

}
