package uk.co.bigredlobster.homegrownGraph.graphs;

import uk.co.bigredlobster.homegrownGraph.IGraph;
import uk.co.bigredlobster.microtypes.PositionX;
import uk.co.bigredlobster.microtypes.PositionY;
import uk.co.bigredlobster.microtypes.WallPosition;

import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;

class GridGraphWithWalls extends ForwardingGraph implements IGraph {
    private GridGraphWithWalls(final IGraph graph) {
        super(graph);
    }

    static class Builder extends BuilderBase {

        private final List<WallPosition> walls;
//        private GridGraph.Builder gridGraphBuilder;

        Builder(final int width, final int height, final List<WallPosition> walls) {
            super(width, height);
            this.walls = checkNotNull(walls);
//            gridGraphBuilder = new GridGraph.Builder(width, height);
        }

        @Override
        public boolean inBounds(final int x, final int y) {
            return x >= 0 && x < width && y >= 0 && y < height && !isWall(x, y);
        }

        private boolean isWall(final int x, final int y) {
            return walls.contains(new WallPosition(new PositionX(x), new PositionY(y)));
        }

        @Override
        public IGraph build() {
            return new GridGraphWithWalls(
                    super.build()
            );
        }
    }
}
