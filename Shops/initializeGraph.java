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

    private class weightedGraph {
        private String vertex;
        private String adjacentVertex;
        private int weight;

        public weightedGraph(String vertex, String adjacentVertex, int weight) {
            this.vertex = vertex;
            this.adjacentVertex = adjacentVertex;
            this.weight = weight;
        }

        @Override
        // ovveride the toString from Object class
        public String toString() {
            return "(" + vertex + " " + adjacentVertex + "-" + weight + ")";
        }
    }

    private void addVertex(String vertex) {
        // if the vertex does not exist, we add the new one
        if (adjList.get(vertex) == null) {
            adjList.put(vertex, new ArrayList<weightedGraph>());
        } else {
            System.out.println("Operation can't be done! Vertex already existed");
        }
    }

    private void addEdge(String vertex1, String vertex2, int weight) {
        // if the vertices exist, then we add edges
        if (adjList.get(vertex1) != null && adjList.get(vertex2) != null) {
            adjList.get(vertex1).add(new weightedGraph(vertex1, vertex2, weight));
            adjList.get(vertex2).add(new weightedGraph(vertex2, vertex1, weight));
        } else {
            System.out.println("One of the vertices does not exist");
        }
    }

    private void initializeShops() {
        addVertex("MANILA");
        addVertex("MAKATI");
        addVertex("TAGUIG");
        addVertex("QUEZON CITY");
        addVertex("PASIG");
        addVertex("MANDALUYONG");
        addVertex("MARIKINA");

        addEdge("MANILA", "QUEZON CITY", 20);
        addEdge("MANILA", "MANDALUYONG", 10);
        addEdge("MANILA", "MAKATI", 17);
        addEdge("MAKATI", "MANDALUYONG", 15);
        addEdge("MAKATI", "TAGUIG", 7);
        addEdge("TAGUIG", "MANDALUYONG", 16);
        addEdge("TAGUIG", "PASIG", 13);
        addEdge("QUEZON CITY", "MANDALUYONG", 8);
        addEdge("QUEZON CITY", "MARIKINA", 18);
        addEdge("PASIG", "MARIKINA", 20);

    }

    // // minimum spanning tree
    private List<weightedGraph> primMST(Map<String, ArrayList<weightedGraph>> adjList, String startVertex) {
        // it takes hold of the weightedGraph object based off their min weights
        List<weightedGraph> result = new ArrayList<>();
        // keep track of the visited vertices, the function stops once all vertices are
        // visited
        Set<String> visited = new HashSet<>();
        /*
         * Priority queue used to add the minimum weight to the queue. Comparator is
         * there to specify the order of the pq, which are the weights
         * Here, Comparator.comparingInt(w -> w.weight) creates a comparator that
         * compares objects based on their weight field.
         * This comparator is used to order the elements in the priority queue such that
         * objects with smaller weights are dequeued first.
         */

        PriorityQueue<weightedGraph> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(w -> w.weight));
        visited.add(startVertex);
        for (weightedGraph edge : adjList.get(startVertex)) {
            priorityQueue.offer(edge);
        }

        while (!priorityQueue.isEmpty()) {
            weightedGraph currentEdge = priorityQueue.poll(); // man to mad 10 is polled
            String currentVertex = currentEdge.adjacentVertex; // mandaluyong

            if (!visited.contains(currentVertex)) { // if mandaluyong not visited yet
                visited.add(currentVertex); // add mandaluyong
                result.add(currentEdge); // add the vertex of man to mad 10

                for (weightedGraph neighbor : adjList.get(currentVertex)) { // iterates through the edges adjacent to
                                                                            // the current vertex
                    if (!visited.contains(neighbor.adjacentVertex)) { // if the vertex adjacent to mandaluyong hasnt
                                                                      // visited yet
                        priorityQueue.offer(neighbor); // add that vertex to the pQ
                    }
                }
            }
        }
        return result;
    }

    public void printGraph(String startVertex) {
        System.out.println("The Shortest Path from " + startVertex + " to other branches are : ");
        List<weightedGraph> lists = primMST(adjList, startVertex);
        for (weightedGraph list : lists) {
            System.out.println(list.vertex + " " + list.adjacentVertex + " " + list.weight + "KM");
        }
    }

    public int distanceBetweenCities(String startVertex, String destinationVertex) {
        int totalDistance = 0;
        if (startVertex.equals(destinationVertex)) {
            System.out.println("You are already in  " + startVertex + "!");
        } else {
            List<weightedGraph> adjacentVertices = primMST(adjList, startVertex);
            for (weightedGraph listofAdjacentVerticies : adjacentVertices) {
                totalDistance += listofAdjacentVerticies.weight;
                if (listofAdjacentVerticies.adjacentVertex.equals(destinationVertex)) {
                    System.out.println("The total KM between " + startVertex + " and " + destinationVertex + " is "
                            + totalDistance);
                    break;
                }
            }
        }
    return totalDistance;

    }

}
