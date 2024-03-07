package Shops;

import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

public class initializeGraph {
    private Map<String, ArrayList<weightedGraph>> adjList = new HashMap<>();

    public initializeGraph() {
        initializeShops();
    }

    public static class weightedGraph {
        private String vertex;
        private int weight;

        public weightedGraph(String vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }

        @Override
        // ovveride the toString from Object class
        public String toString() {
            return "(" + vertex + ", " + weight + ")";
        }

        // return weight?
        public int getWeight() {
            return weight;
        }
    }

    public void addVertex(String vertex) {
        // if the vertex does not exist, we add the new one
        if (adjList.get(vertex) == null) {
            adjList.put(vertex, new ArrayList<weightedGraph>());
        } else {
            System.out.println("Operation can't be done! Vertex already existed");
        }
    }

    public void addEdge(String vertex1, String vertex2, int weight) {
        // if the vertices exist, then we add edges
        if (adjList.get(vertex1) != null && adjList.get(vertex2) != null) {
            adjList.get(vertex1).add(new weightedGraph(vertex2, weight));
            adjList.get(vertex2).add(new weightedGraph(vertex1, weight));
        } else {
            System.out.println("One of the vertices does not exist");
        }
    }

    public void initializeShops() {
        addVertex("MANILA");
        addVertex("MAKATI");
        addVertex("TAGUIG");
        addVertex("QUEZON CITY");
        addVertex("PASIG");
        addVertex("MANDALUYONG");
        addVertex("MARIKINA");

        addEdge("MANILA", "QUEZON CITY", 13);
        addEdge("MANILA", "MAKATI", 25);
        addEdge("MANILA", "MANDALUYONG", 12);

        addEdge("MAKATI", "TAGUIG", 36);
        addEdge("MAKATI", "MANDALUYONG", 13);

        addEdge("MANDALUYONG", "QUEZON CITY", 21);
        addEdge("MANDALUYONG", "TAGUIG", 37);

        addEdge("TAGUIG", "PASIG", 14);

        addEdge("QUEZON CITY", "MARIKINA", 25);

        addEdge("MARIKINA", "PASIG", 19);

    }

    public void printGraph() {
        for (Map.Entry<String, ArrayList<weightedGraph>> entries : adjList.entrySet()) {
            System.out.println(entries.getKey() + "=" + entries.getValue() + "\n");
        }
    }
}
