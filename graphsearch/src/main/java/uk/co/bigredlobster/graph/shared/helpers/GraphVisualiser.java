package uk.co.bigredlobster.graph.shared.helpers;

import uk.co.bigredlobster.graph.basicGridWithWalls.GridGraphWithWalls;
import uk.co.bigredlobster.graph.shared.node.GraphNode;
import uk.co.bigredlobster.graph.shared.node.GridPosition;
import uk.co.bigredlobster.microtypes.HasVisitedAndWhen;
import uk.co.bigredlobster.microtypes.PositionX;
import uk.co.bigredlobster.microtypes.PositionY;
import uk.co.bigredlobster.microtypes.WallPosition;

import java.util.List;

public class GraphVisualiser {
    public final int width;
    public final int height;
    public final List<WallPosition> walls;

    public GraphVisualiser(int width, int height, List<WallPosition> walls) {
        this.width = width;
        this.height = height;
        this.walls = walls;
    }

    public void drawGrid(GridGraphWithWalls graph) {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                final int theX = x;
                final int theY = y;
                final GraphNode node = graph.graph.nodes().stream()
                        .filter(z -> z.position.equals(new GridPosition(new PositionX(theX), new PositionY(theY))))
                        .findFirst()
                        .orElseThrow(RuntimeException::new);
                System.out.print(drawTile(node, new Object(), DrawStyle.RAW));
            }
            System.out.println();
        }
    }


    public String drawTile(final GraphNode node, final Object data, final DrawStyle style) {
        if (walls.contains(new WallPosition(node.position.x, node.position.y)))
            return "#";

        switch (style) {
            case START:
                return "S";
            case GOAL:
                return "G";
            case NUMBERS:
                final HasVisitedAndWhen hasVisitedAndWhen = (HasVisitedAndWhen) data;
                return String.valueOf(hasVisitedAndWhen.when.value);
            case FROM:
                final GraphNode from = (GraphNode) data;
                if (node.position.x.value == from.position.x.value + 1)
                    return "<";
                else if (node.position.x.value == from.position.x.value - 1)
                    return ">";
                else if (node.position.y.value == from.position.y.value + 1)
                    return "^";
                else if (node.position.y.value == from.position.y.value - 1)
                    return "v";
            case RAW:
                return ".";
            case PATH:
                return "X";
            default:
                throw new RuntimeException("Missing DrawStyle");
        }
    }


    /*
    def from_id_width(id, width):
    return (id % width, id // width)

def draw_tile(graph, id, style, width):
    r = "."
    if 'number' in style and id in style['number']: r = "%d" % style['number'][id]
    if 'point_to' in style and style['point_to'].get(id, None) is not None:
        (x1, y1) = id
        (x2, y2) = style['point_to'][id]
        if x2 == x1 + 1: r = ">"
        if x2 == x1 - 1: r = "<"
        if y2 == y1 + 1: r = "v"
        if y2 == y1 - 1: r = "^"
    if 'start' in style and id == style['start']: r = "A"
    if 'goal' in style and id == style['goal']: r = "Z"
    if 'path' in style and id in style['path']: r = "@"
    if id in graph.walls: r = "#" * width
    return r

def draw_grid(graph, width=2, **style):
    for y in range(graph.height):
        for x in range(graph.width):
            print("%%-%ds" % width % draw_tile(graph, (x, y), style, width), end="")
        print()

     */

}
