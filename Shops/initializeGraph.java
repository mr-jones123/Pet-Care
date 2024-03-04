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
        addVertex("Pet Care: MANILA"); //root
        addVertex("Pet Care: MAKATI");
        addVertex("Pet Care: TAGUIG");
        addVertex("Pet Care: MANDALUYONG");
        addVertex("Pet Care: MARKINA");// destination
        //MANILA CONNECTIONS
        addEdge("Pet Care: MANILA","Pet Care: MAKATI",3 );
        addEdge("Pet Care: MANILA","Pet Care: TAGUIG",5 );
        addEdge("Pet Care: MANILA","Pet Care: MARIKINA",24 );
        // MAKATI CONNECTIONS
        addEdge("Pet Care: MAKATI","Pet Care: MANDALUYONG",2 );
        // TAGUIG CONNECTIONS
        addEdge("Pet Care: TAGUIG","Pet Care: MARIKINA",15 );
        // MANDALUYONG CONNECTIONS
        addEdge("Pet Care: MANDALUYONG","Pet Care: MARIKINA",7 );
    }
    // visits the neighboring verticies 
    // ideal when looking for the nearest branch
    // BFS
    public void nearestShop(String startVertex) {
    }
    // DFS
    public void farthestShop(String startVertex){
        
    }
    public void printGraph() {
        for (Map.Entry<String, ArrayList<weightedGraph>> entries : adjList.entrySet()) {
            System.out.println(entries.getKey() + "=" + entries.getValue() + "\n");
        }
    }
}
