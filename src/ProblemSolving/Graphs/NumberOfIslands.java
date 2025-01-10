package ProblemSolving.Graphs;

public class NumberOfIslands {

    public static void main(String[] args) {
        int[][] island1 = {
                {1, 1, 0, 0, 0},
                {0, 1, 0, 0, 1},
                {1, 0, 0, 1, 1},
                {0, 0, 0, 0, 0},
                {1, 0, 1, 0, 1}
        };
        System.out.println(numIslands(island1));
        int[][] island = {
                {1, 1, 0, 0, 0},
                {0, 0, 0, 0, 1},
                {1, 0, 0, 1, 1},
                {0, 0, 0, 0, 0},
                {1, 0, 1, 0, 1}
        };
        System.out.println(numIslands(island));
    }

    public static int numIslands(int[][] island){
        int c=0;
        for(int i=0;i<island.length;i++){
            for(int j=0;j<island[i].length;j++){
                if(island[i][j]==1){
                    c++;
                    dfs(island,i,j);
                }
            }
        }
        return c;
    }

    public static void dfs(int[][] island, int i, int j){
        if(i<0|| i>=island.length || j<0|| j>=island[i].length||island[i][j]==0)
            return;
        island[i][j]=0;
        dfs(island,i+1,j);
        dfs(island,i-1,j);
        dfs(island,i,j+1);
        dfs(island,i,j-1);
        dfs(island,i+1,j+1);
        dfs(island,i-1,j-1);
        dfs(island,i+1,j-1);
        dfs(island,i-1,j+1);
    }
}
