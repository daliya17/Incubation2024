package ProblemSolving.Graphs;

import java.util.LinkedList;
import java.util.Queue;

public class MultiSourceBFS {
    public static void main(String[] args) {
        Graph graph = new Graph(8, true);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);
        graph.addEdge(6, 7);
        graph.printGraph();
        multiSourceBFS(graph, new int[]{0, 6});
    }

   public static void multiSourceBFS(Graph graph, int[] sources) {
        boolean[] visited = new boolean[graph.adjList.size()];
        Queue<Integer> queue = new LinkedList<>();
        for (int source : sources) {
            queue.add(source);
            visited[source] = true;
        }
        while (!queue.isEmpty()) {
            int current = queue.poll();
            System.out.print(current + " ");
            for (int vertex : graph.adjList.get(current)) {
                if (!visited[vertex]) {
                    queue.add(vertex);
                    visited[vertex] = true;
                }
            }
        }
    }
}
