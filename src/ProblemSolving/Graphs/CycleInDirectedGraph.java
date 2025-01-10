package ProblemSolving.Graphs;

public class CycleInDirectedGraph {
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
        System.out.println(hasCycle(graph));
    }

    public static boolean hasCycle(Graph graph) {
        boolean[] visited = new boolean[graph.adjList.size()];
        boolean[] recStack = new boolean[graph.adjList.size()];
        for (int i = 0; i < graph.adjList.size(); i++) {
            if (dfs(graph, i, visited, recStack)) {
                return true;
            }
        }
        return false;
    }

    public static boolean dfs(Graph graph, int node, boolean[] visited, boolean[] recStack) {
        // if the node is already in the recursion stack, then there is a cycle
        if (recStack[node]) {
            return true;
        }
        // if the node is already visited, then there is no cycle
        if (visited[node]) {
            return false;
        }
        // mark the node as visited and add it to the recursion stack
        visited[node] = true;
        recStack[node] = true;
        for (int i = 0; i < graph.adjList.get(node).size(); i++) {
            int v = graph.adjList.get(node).get(i);
            // if the node is not visited, then visit it
            if (dfs(graph, v, visited, recStack)) {
                return true;
            }
        }
        // remove the node from the recursion stack
        recStack[node] = false;
        return false;
    }

    // Time Complexity: O(V + E)
    // Space Complexity: O(V)
    // dry run the code with the following graph:
    // 0 -> 1 -> 2 -> 3 -> 4 -> 5
    // 6 -> 7
    // the output should be false
    // visit the node 0, mark it as visited and add it to the recursion stack
    // visit the node 1, mark it as visited and add it to the recursion stack
    // visit the node 2, mark it as visited and add it to the recursion stack
    // visit the node 3, mark it as visited and add it to the recursion stack
    // visit the node 4, mark it as visited and add it to the recursion stack
    // visit the node 5, mark it as visited and add it to the recursion stack
    // remove the node 5 from the recursion stack
    // remove the node 4 from the recursion stack
    // remove the node 3 from the recursion stack
    // remove the node 2 from the recursion stack
    // remove the node 1 from the recursion stack
    // remove the node 0 from the recursion stack
    // visit the node 6, mark it as visited and add it to the recursion stack
    // visit the node 7, mark it as visited and add it to the recursion stack
    // remove the node 7 from the recursion stack
    // remove the node 6 from the recursion stack
    // the output should be false


    // 0 -> 1 -> 2 -> 3 -> 4 -> 5 -> 3
    // 6 -> 7
    // visit the node 0, mark it as visited and add it to the recursion stack
    // visit the node 1, mark it as visited and add it to the recursion stack
    // visit the node 2, mark it as visited and add it to the recursion stack
    // visit the node 3, mark it as visited and add it to the recursion stack
    // visit the node 4, mark it as visited and add it to the recursion stack
    // visit the node 5, mark it as visited and add it to the recursion stack
    // visit the node 3, since the node 3 is already in the recursion stack, there is a cycle
    // the output should be true
}
