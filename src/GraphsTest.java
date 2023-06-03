import edgeWeightedGraph.MyGraph;
import searches.BreadthFirstSearch;
import searches.DepthFirstSearch;
import searches.DijkstraSearch;
import searches.Search;
import vertexWeightedGraph.WeightedGraph;

public class GraphsTest {

    public static void main(String[] args) {
//        MyGraph<String> graph = new MyGraph<>();
//
//        graph.addVertex("A");
//        graph.addVertex("B");
//        graph.addVertex("C");
//        graph.addVertex("D");
//        graph.addVertex("E");
//
//        graph.addEdge("A", "B");
//        graph.addEdge("A", "E");
//        graph.addEdge("E", "C");
//        graph.addEdge("B", "E");
//        graph.addEdge("B", "C");
//        graph.addEdge("C", "D");
//
//        graph.print();
//        System.out.println();
//
//        System.out.println("Has edge A-E: " + graph.hasEdge("A", "E"));
//        System.out.println("Has edge E-A: " + graph.hasEdge("E", "A"));
//        System.out.println("Has edge A-C: " + graph.hasEdge("A", "C"));
//
//        System.out.println("Vertices count - " + graph.getVerticesCount());
//        System.out.println("Edges count - " + graph.getEdgesCount());
//
//        System.out.println("Has vertex A: " + graph.hasVertex("A"));
//        System.out.println("Has vertex G: " + graph.hasVertex("G"));

//        WeightedGraph<String> weightedGraph = new WeightedGraph<>();
//
//        weightedGraph.addVertex("A");
//        weightedGraph.addVertex("B");
//        weightedGraph.addVertex("C");
//        weightedGraph.addVertex("D");
//        weightedGraph.addVertex("E");
//
//        weightedGraph.addEdge("A", "B", 2);
//        weightedGraph.addEdge("A", "E", 7);
//        weightedGraph.addEdge("E", "C", 1);
//        weightedGraph.addEdge("B", "E", 6);
//        weightedGraph.addEdge("B", "C", 2);
//        weightedGraph.addEdge("C", "D", 1);
//
//        weightedGraph.print();
//        System.out.println();
//
//        System.out.println("Has edge A-E: " + weightedGraph.hasEdge("A", "E"));
//        System.out.println("Has edge E-A: " + weightedGraph.hasEdge("E", "A"));
//        System.out.println("Has edge A-C: " + weightedGraph.hasEdge("A", "C"));
//
//        System.out.println("Vertices count - " + weightedGraph.getVerticesCount());
//        System.out.println("Edges count - " + weightedGraph.getEdgesCount());
//
//        System.out.println("Has vertex A: " + weightedGraph.hasVertex("A"));
//        System.out.println("Has vertex G: " + weightedGraph.hasVertex("G"));
//        System.out.println();


        WeightedGraph<String> graph = new WeightedGraph<>(true);

        graph.addEdge("Almaty", "Astana", 2.1);
        graph.addEdge("Almaty", "Shymkent", 7.2);
        graph.addEdge("Shymkent", "Astana", 3.9);
        graph.addEdge("Astana", "Kostanay", 3.5);
        graph.addEdge("Shymkent", "Kyzylorda", 5.4);

        System.out.println("Dijkstra:");
        Search<String> djk = new DijkstraSearch<>(graph, "Almaty");
        outputPath(djk, "Kyzylorda");

        System.out.println("\n--------------------------------");

        System.out.println("DFS:");
        Search<String> dfs = new DepthFirstSearch<>(graph, "Almaty");
        outputPath(dfs, "Kyzylorda");

        System.out.println("\n--------------------------------");

        System.out.println("BFS:");
        Search<String> bfs = new BreadthFirstSearch<>(graph, "Almaty");
        outputPath(bfs, "Kyzylorda");
    }

    public static void outputPath(Search<String> search, String key) {
        Iterable<String> path = search.pathTo(key);
        if (path != null) {
            for (String v : path) {
                System.out.print(v + " -> ");
            }
        } else {
            System.out.println("No path found.");
        }
    }
}
