package uk.co.bigredlobster.graph.search.cost;

import com.google.common.collect.ImmutableMap;
import uk.co.bigredlobster.microtypes.NodeCost;

import java.util.Map;

public class CostAndCameFrom {
    public final ImmutableMap<GraphNodeWithCost, GraphNodeWithCost> cameFrom;
    public final ImmutableMap<GraphNodeWithCost, NodeCost> costSoFar;

    public CostAndCameFrom(Map<GraphNodeWithCost, GraphNodeWithCost> cameFrom, Map<GraphNodeWithCost, NodeCost> costSoFar) {
        this.cameFrom = ImmutableMap.copyOf(cameFrom);
        this.costSoFar = ImmutableMap.copyOf(costSoFar);
    }
}
