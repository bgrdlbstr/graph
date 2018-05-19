package uk.co.bigredlobster.graph.searchAlgos;

import uk.co.bigredlobster.graph.nodes.GraphNode;
import uk.co.bigredlobster.microtypes.HasVisited;

import java.util.Map;

public interface IGraphSearch {
    Map<GraphNode, HasVisited> search(GraphNode start);
}
