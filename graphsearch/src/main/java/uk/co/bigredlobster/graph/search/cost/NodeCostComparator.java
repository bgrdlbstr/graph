package uk.co.bigredlobster.graph.search.cost;

import java.util.Comparator;

public class NodeCostComparator implements Comparator<GraphNodeWithCost> {
    @Override
    public int compare(GraphNodeWithCost o1, GraphNodeWithCost o2) {
        return o1.cost.value.compareTo(o2.cost.value);
    }
}
