package vertexWeightedGraph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class WeightedGraph<V> {

    private final boolean undirected;
    private final Map<V, Vertex<V>> vertices;

    public WeightedGraph() {
        this(true);
    }

    public WeightedGraph(boolean undirected) {
        this.undirected = undirected;
        vertices = new HashMap<>();
    }

    public void addVertex(V v) {
        if (hasVertex(v))
            return;
        vertices.put(v, new Vertex<>(v));
    }

    public void addEdge(V source, V dest, double weight) {
        addVertex(source);
        addVertex(dest);

        if (hasEdge(source, dest) || source.equals(dest))
            return;

        vertices.get(source).addAdjacentVertex(vertices.get(dest), weight);

        if (undirected)
            vertices.get(dest).addAdjacentVertex(vertices.get(source), weight);
    }

    public Vertex<V> getVertex(V v) {
        return vertices.get(v);
    }

    public int getVerticesCount() {
        return vertices.size();
    }

    public int getEdgesCount() {
        int sum = 0;
        for (Vertex<V> v : vertices.values()) {
            sum += v.getAdjacentVertices().size();
        }

        if (undirected) {
            sum /= 2;
        }

        return sum;
    }

    public boolean hasVertex(V v) {
        return vertices.containsKey(v);
    }

    public boolean hasEdge(V source, V dest) {
        if (!hasVertex(source))
            return false;
        return vertices.get(source).getAdjacentVertices().containsKey(vertices.get(dest));
    }

    public Iterable<V> getAdjacentVertices(V v) {
        Vertex<V> vertex = vertices.get(v);
        if (vertex == null)
            return null;

        List<V> adjacentVertices = new LinkedList<>();
        for (Vertex<V> adjVertex : vertex.getAdjacentVertices().keySet()) {
            adjacentVertices.add(adjVertex.getData());
        }
        return adjacentVertices;
    }

    public Iterable<Vertex<V>> getEdges(V vertex) {
        return vertices.get(vertex).getAdjacentVertices().keySet();
    }

    public void print() {
        for (V vertex : vertices.keySet()) {
            System.out.print(vertex + " -> ");
            for (Vertex<V> adjVertex : vertices.get(vertex).getAdjacentVertices().keySet()) {
                System.out.print(adjVertex.getData() + " -> ");
            }
            System.out.println();
        }
    }
}
