package ProblemSolving.Graphs;

import java.util.ArrayList;
import java.util.List;

public class Graph {
    public List<List<Integer>> adjList;
    private final boolean isDirected;

    public Graph(int vertices, boolean isDirected) {
        this.isDirected = isDirected;
        adjList = new ArrayList<>();
        for (int i = 0; i < vertices; i++)
            adjList.add(new ArrayList<>());
    }

    public void addEdge(int u, int v) {
        adjList.get(u).add(v); // Directed graph, u -> v
    }

    public void addUndirectedEdge(int u, int v) {
        adjList.get(u).add(v);
        adjList.get(v).add(u);
    }

    public void printGraph() {
        for (int i = 0; i < adjList.size(); i++) {
            if(isDirected)
                System.out.print(i + " -> ");
            else
                System.out.print(i + " - ");
            for (int j = 0; j < adjList.get(i).size(); j++) {
                System.out.print(adjList.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

    public int getVertices() {
        return adjList.size();
    }

    public int getEdges() {
        int edges = 0;
        for (int i = 0; i < adjList.size(); i++) {
            edges += adjList.get(i).size();
        }
        if(!isDirected)
            edges /= 2;
        return edges;
    }
}
