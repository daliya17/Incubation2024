package Interviews;

public class ChamberExploration {
    public static void main(String[] args) {
        char[][] cave1 = {
                {'.', '.', '.'},
                {'X', 'X', '.'},
                {'.', '.', '.'}
        };
        System.out.println(maxChambersExplored(cave1)); // Output: 5

        // Example 2: No Possible Path
        char[][] cave2 = {
                {'.', 'X', '.'},
                {'X', 'X', '.'},
                {'.', 'X', 'X'}
        };
        System.out.println(maxChambersExplored(cave2)); // Output: -1

        // Example 3: Large Grid with Multiple Paths
        char[][] cave3 = {
                {'.', '.', 'X', '.', '.'},
                {'X', '.', 'X', 'X', '.'},
                {'.', '.', '.', 'X', '.'},
                {'X', 'X', '.', '.', '.'},
                {'.', '.', 'X', '.', '.'}
        };
        System.out.println(maxChambersExplored(cave3)); // Output: 9

        // Example 4: Large Open Cave
        char[][] cave4 = {
                {'.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.'}
        };
        System.out.println(maxChambersExplored(cave4)); // Output: 25

        // Example 5: Tricky Path
        char[][] cave5 = {
                {'.', 'X', 'X', 'X', '.'},
                {'.', 'X', '.', '.', '.'},
                {'.', 'X', 'X', 'X', '.'},
                {'.', '.', '.', 'X', '.'},
                {'X', 'X', '.', 'X', '.'}
        };
        System.out.println(maxChambersExplored(cave5)); // Output: 8
    }

    public static int maxChambersExplored(char[][] board) {
        return dfs(board,0,0);
    }

    public static int dfs(char[][] board, int i, int j) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] == 'X')
            return 0;
        board[i][j] = 'X';
        int down = dfs(board, i + 1, j);
        int left = dfs(board, i, j - 1);
        int right = dfs(board, i, j + 1);
        return 1 + Math.max(down, Math.max(left, right));
    }
}
