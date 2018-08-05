package uk.co.bigredlobster.graph.search.cost;

import uk.co.bigredlobster.graph.basicGridWithCost.node.GraphNodeWithCost;

import java.util.Comparator;

public class GraphNodeWithCostComparator implements Comparator<GraphNodeWithCost> {
    @Override
    public int compare(GraphNodeWithCost o1, GraphNodeWithCost o2) {
        return o1.nodeCost.value.compareTo(o2.nodeCost.value);
    }
}
