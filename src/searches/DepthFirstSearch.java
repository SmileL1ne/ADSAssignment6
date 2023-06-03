package searches;

import vertexWeightedGraph.WeightedGraph;

public class DepthFirstSearch<V> extends Search<V> {

    public DepthFirstSearch(WeightedGraph<V> graph, V source) {
        super(source);
        dfs(graph, source);
    }

    private void dfs(WeightedGraph<V> graph, V current) {
        marked.add(current);
        for (V v : graph.getAdjacentVertices(current)) {
            if (!marked.contains(v)) {
                edgeTo.put(v, current);
                dfs(graph, v);
            }
        }
    }
}
