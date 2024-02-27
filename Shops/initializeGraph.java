package Shops;

import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

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
        addVertex("Pet Care Manila");
        addVertex("Pet Care Quezon");
        addVertex("Pet Care Makati");
        addVertex("Pet Care Taguig");
        addVertex("Pet Care Caloocan");

        addEdge("Pet Care Manila", "Pet Care Quezon", 5);
        addEdge("Pet Care Manila", "Pet Care Makati", 10);
        addEdge("Pet Care Makati", "Pet Care Taguig", 3);
        addEdge("Pet Care Taguig", "Pet Care Caloocan", 15);
    }
    // visits the neighboring verticies 
    // ideal when looking for the nearest branch
    public void breadthFirstSearch(String startVertex) {
    }
    // goes as far as possible
    public void depthFirstSearch(String startVertex){
        
    }
    public void printGraph() {
        for (Map.Entry<String, ArrayList<weightedGraph>> entries : adjList.entrySet()) {
            System.out.println(entries.getKey() + "=" + entries.getValue() + "\n");
        }
    }
}
