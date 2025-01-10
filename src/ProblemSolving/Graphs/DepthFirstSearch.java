package ProblemSolving.Graphs;

import java.util.Stack;

public class DepthFirstSearch {
    public static void main(String[] args) {
        Graph graph = new Graph(4, true);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
//        graph.addEdge(2, 3);
//        graph.addEdge(3, 3);
        System.out.println(graph.getEdges());
        graph.printGraph();
        boolean[] visited = new boolean[graph.adjList.size()];
        System.out.println(dfs(graph, 0, 3, visited));
        System.out.println(dfsStack(graph, 0, 3, visited));
        // System.out.println(visited[3]);
    }

    public static boolean dfs(Graph graph, int start, int end, boolean[] visited) {
        if (start == end)
            return true;

        visited[start] = true;
       // System.out.println(start + " ");
        for (int i = 0; i < graph.adjList.get(start).size(); i++) {
            int v = graph.adjList.get(start).get(i);
            if (!visited[v]) {
                if (dfs(graph, v, end, visited))
                    return true;
            }
        }
        return visited[end];
    }


    // bfs using stack
    public static boolean dfsStack(Graph graph, int start, int end, boolean[] visited) {
        Stack<Integer> stack = new Stack<>();
        stack.push(start);
        visited[start] = true;
        while (!stack.isEmpty()) {
            int current = stack.pop();
            if (current == end) {
                return true;
            }
            for (int vertex : graph.adjList.get(current)) {
                if (!visited[vertex]) {
                    stack.push(vertex);
                    visited[vertex] = true;
                }
            }
        }
        return visited[end];
    }
}
