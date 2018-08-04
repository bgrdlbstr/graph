package uk.co.bigredlobster.homegrownGraph.graphs;

import uk.co.bigredlobster.homegrownGraph.nodes.IGraphNode;
import uk.co.bigredlobster.microtypes.HasVisitedAndWhen;

import java.util.Map;

public interface IGraphSearch {
    Map<IGraphNode, HasVisitedAndWhen> search(IGraphNode start);
}
