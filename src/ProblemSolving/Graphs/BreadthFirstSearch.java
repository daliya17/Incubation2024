package ProblemSolving.Graphs;

import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch {
    public static void main(String[] args) {
        Graph graph = new Graph(6, true);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 4);
        graph.addEdge(3, 4);
        graph.addEdge(3, 5);
        graph.addEdge(4, 5);
        graph.printGraph();
        System.out.println(bfs(graph, 0, 5));
        System.out.println(ShortestPath(graph, 0, 5));
    }

    public static boolean bfs(Graph graph, int start, int end) {
        boolean[] visited = new boolean[graph.adjList.size()];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        while (!queue.isEmpty()) {
            int current = queue.poll();
            if (current == end) {
                return true;
            }
            for (int vertex : graph.adjList.get(current)) {
                if (!visited[vertex]) {
                    queue.add(vertex);
                    visited[vertex] = true;
                }
            }
        }
        return visited[end];
    }

    public static int ShortestPath(Graph graph, int start, int end) {
        boolean[] visited = new boolean[graph.adjList.size()];
        int[] distance = new int[graph.adjList.size()];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        distance[start] = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int current = queue.poll();
                for (int vertex : graph.adjList.get(current)) {
                    if (!visited[vertex]) {
                        queue.add(vertex);
                        visited[vertex] = true;
                        distance[vertex] = distance[current] + 1;
                    }
                }
            }
        }
        return distance[end];
    }
}
