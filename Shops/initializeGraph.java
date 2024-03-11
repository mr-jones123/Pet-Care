package Shops;

import java.util.Map;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.ArrayList;
import java.util.Comparator;
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

        addEdge("MANILA", "QUEZON CITY", 10);
        addEdge("MANILA", "MAKATI", 6);
        addEdge("MANILA", "MANDALUYONG", 12);

        addEdge("MAKATI", "TAGUIG", 3 );
        addEdge("MAKATI", "MANDALUYONG", 4);

        addEdge("MANDALUYONG", "QUEZON CITY", 7);
        addEdge("MANDALUYONG", "TAGUIG", 8);
        addEdge("MANDALUYONG", "PASIG", 14);

        addEdge("TAGUIG", "PASIG", 5);

        addEdge("QUEZON CITY", "MARIKINA", 9);

        addEdge("MARIKINA", "PASIG", 7 );

    }
    //minimum spanning tree 
    public List<weightedGraph> primMST(String startVertex){
        // stores the list of weighted graph 
        List<weightedGraph> result = new ArrayList<>();
        // checks the visited nodes
        Set<String> visited = new HashSet<>();
        // priority queue
        // comparator sorts the objects, in this case, sorts the weights
        PriorityQueue<weightedGraph> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(weightedGraph::getWeight));    
        visited.add(startVertex);
        priorityQueue.addAll(adjList.get(startVertex));
        while (!priorityQueue.isEmpty()){
            weightedGraph currentEdge = priorityQueue.poll();
            String currentVertex = currentEdge.vertex;  
            if (!visited.contains(currentVertex)){
                visited.add(currentVertex);
                result.add(currentEdge);

                ArrayList<weightedGraph> neighbors = adjList.get(currentVertex);
                priorityQueue.addAll(neighbors);
            }
        }
    return result;

    }
    public void printGraph() {
        List<weightedGraph> mst = new ArrayList<>(primMST("MANILA"));
        for (weightedGraph edge : mst){
            System.out.println(edge);
        }
    }
}
