package uk.co.bigredlobster.graph.searchAlgos;

import uk.co.bigredlobster.graph.nodes.IGraphNode;
import uk.co.bigredlobster.microtypes.HasVisited;
import uk.co.bigredlobster.microtypes.HasVisitedAndWhen;

import java.util.Map;

public interface IGraphSearch {
    Map<IGraphNode, HasVisitedAndWhen> search(IGraphNode start);
}
