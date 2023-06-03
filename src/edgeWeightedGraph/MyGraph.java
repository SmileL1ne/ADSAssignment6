package edgeWeightedGraph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class MyGraph<Vertex> {

    private final boolean undirected;
    private Map<Vertex, List<Vertex>> map;

    public MyGraph() {
        this.undirected = true;
        map = new HashMap<>();
    }

    public MyGraph(boolean undirected) {
        this.undirected = undirected;
        map = new HashMap<>();
    }

    public void addVertex(Vertex v) {
        map.put(v, new LinkedList<>());
    }

    public void addEdge(Vertex source, Vertex dest) {
        if (!hasVertex(source)) {
            addVertex(source);
        }
        if (!hasVertex(dest)) {
            addVertex(dest);
        }
        if (hasEdge(source, dest) || source.equals(dest)) {
            return;
        }

        map.get(source).add(dest);

        if (undirected) {
            map.get(dest).add(source);
        }
    }

    public int getVerticesCount() {
        return map.size();
    }

    public int getEdgesCount() {
        int sum = 0;
        for (List<Vertex> lv : map.values()) {
            sum += lv.size();
        }
        if (undirected) {
            return sum / 2;
        }
        return sum;
    }

    public boolean hasVertex(Vertex v) {
        return map.containsKey(v);
    }

    public boolean hasEdge(Vertex source, Vertex dest) {
        if (!hasVertex(source)) return false;
        return map.get(source).contains(dest);
    }

    public Iterable<Vertex> adjacencyList(Vertex v) {
        if (!hasVertex(v)) return null;
        return map.get(v);
    }

    public void print() {
        int i = 0;
        for (List<Vertex> currentList : map.values()) {
            System.out.print(map.keySet().toArray()[i] + " -> ");
            i++;
            for (Vertex vertex : currentList) {
                System.out.print(vertex + " -> ");
            }
            System.out.println();
        }
    }
}
