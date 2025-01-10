package ProblemSolving.Graphs;

public class CycleInUnDirectedGraph {
    public static void main(String[] args) {
        Graph graph = new Graph(8, false);
        graph.addUndirectedEdge(0, 1);
        graph.addUndirectedEdge(1, 2);
        graph.addUndirectedEdge(2, 3);
        graph.addUndirectedEdge(3, 4);
        graph.addUndirectedEdge(4, 5);
        graph.addUndirectedEdge(6, 7);
        graph.addUndirectedEdge(7, 6);
        //      System.out.println(graph.getEdges());
        graph.printGraph();
        System.out.println(hasCycle(graph));
    }

    public static boolean hasCycle(Graph graph) {
        boolean[] visited = new boolean[graph.adjList.size()];
        int c = 0;
        for (int i = 0; i < graph.adjList.size(); i++) {
            if (!visited[i]) {
                dfs(graph, i, visited);
                c++;
            }
        }
        int edges = graph.getEdges();
        int nodes = graph.adjList.size();
        if(edges>nodes-c)
            return true;
        return false;
    }

    public static void dfs(Graph graph, int node, boolean[] visited) {
        if (visited[node])
            return;
        visited[node] = true;
        for (int i = 0; i < graph.adjList.get(node).size(); i++) {
            int v = graph.adjList.get(node).get(i);
            if (!visited[v])
                dfs(graph, v, visited);
        }
    }
}
