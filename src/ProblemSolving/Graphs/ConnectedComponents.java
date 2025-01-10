package ProblemSolving.Graphs;

public class ConnectedComponents {
    public static void main(String[] args) {
        Graph graph = new Graph(8,true);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 3);
        graph.addEdge(3,4);
        graph.addEdge(4, 5);
        graph.addEdge(6,7);
        graph.printGraph();
        System.out.println(countConnectedComponents(graph));
    }

    public static int countConnectedComponents(Graph graph){
        boolean[] visited = new boolean[graph.adjList.size()];
        int c=0;
        for(int i=0;i<graph.adjList.size();i++){
            if(!visited[i]) {
                dfs(graph, i, visited);
                c++;
            }
        }
        return c;
    }

    public static void dfs(Graph graph, int node,boolean[] visited){
        if(visited[node])
            return;
        visited[node]=true;
        for(int i=0;i<graph.adjList.get(node).size();i++){
            int v= graph.adjList.get(node).get(i);
            if(!visited[v])
                dfs(graph,v,visited);
        }
    }
}
