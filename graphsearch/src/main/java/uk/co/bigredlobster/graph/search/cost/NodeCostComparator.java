package uk.co.bigredlobster.graph.search.cost;

import uk.co.bigredlobster.microtypes.NodeCost;

import java.util.Comparator;

public class NodeCostComparator implements Comparator<NodeCost> {
    @Override
    public int compare(NodeCost o1, NodeCost o2) {
        return o1.value.compareTo(o2.value);
    }
}
