package ProblemSolving.Arrays.TwoDimentionalArrays;

import java.util.*;

public class FindSnakePassage {


    public static void main(String[] args) {
        char[][] board1 = new char[][]{
                {'+', '+', '+', '+', '+', '+', '+', '0', '0'},
                {'+', '+', '0', '0', '0', '0', '0', '+', '+'},
                {'0', '0', '0', '0', '0', '+', '+', '0', '+'},
                {'+', '+', '0', '+', '+', '+', '+', '0', '0'},
                {'+', '+', '0', '0', '0', '0', '0', '0', '+'},
                {'+', '+', '0', '+', '+', '0', '+', '0', '+'}};
        int[] start1_1 = {2, 0}; // Expected output = {5, 2}
        int[] start1_2 = {0, 7}; // Expected output = {0, 8}
        int[] start1_3 = {5, 2}; // Expected output = {2, 0} or {5, 5}
        int[] start1_4 = {5, 5}; // Expected output = {5, 7}

        char[][] board2 = new char[][]{{'+', '+', '+', '+', '+', '+', '+'},
                {'0', '0', '0', '0', '+', '0', '+'},
                {'+', '0', '+', '0', '+', '0', '0'},
                {'+', '0', '0', '0', '+', '+', '+'},
                {'+', '+', '+', '+', '+', '+', '+'}};
        int[] start2_1 = {1, 0}; // Expected output = null (or a special value representing no possible exit)
        int[] start2_2 = {2, 6}; // Expected output = null

        char[][] board3 = new char[][]{{'+', '0', '+', '0', '+'},
                {'0', '0', '+', '0', '0'},
                {'+', '0', '+', '0', '+'},
                {'0', '0', '+', '0', '0'},
                {'+', '0', '+', '0', '+'}};
        int[] start3_1 = {0, 1}; // Expected output = {1, 0}
        int[] start3_2 = {4, 1}; // Expected output = {3, 0}
        int[] start3_3 = {0, 3}; // Expected output = {1, 4}
        int[] start3_4 = {4, 3}; // Expected output = {3, 4}

        char[][] board4 = new char[][]{{'+', '0', '+', '0', '+'},
                {'0', '0', '0', '0', '0'},
                {'+', '+', '+', '+', '+'},
                {'0', '0', '0', '0', '0'},
                {'+', '0', '+', '0', '+'}};
        int[] start4_1 = {1, 0}; // Expected output = {0, 1}
        int[] start4_2 = {1, 4}; // Expected output = {0, 3}
        int[] start4_3 = {3, 0}; // Expected output = {4, 1}
        int[] start4_4 = {3, 4}; // Expected output = {4, 3}

        char[][] board5 = new char[][]{{'+', '0', '0', '0', '+'},
                {'+', '0', '+', '0', '0'},
                {'+', '0', '0', '0', '0'},
                {'+', '0', '0', '0', '+'}};
        int[] start5_1 = {0, 1}; // Expected output = (0, 2)
        int[] start5_2 = {3, 1}; // Expected output = (3, 2)
        int[] start5_3 = {1, 4}; // Expected output = (2, 4)

        char[][] board6 = new char[][]{{'+', '+', '+', '+', '+', '+', '+', '+'},
                {'0', '0', '0', '0', '0', '0', '0', '0'},
                {'+', '0', '0', '0', '0', '0', '0', '0'},
                {'+', '0', '0', '0', '0', '0', '0', '+'},
                {'0', '0', '0', '0', '0', '0', '0', '+'},
                {'+', '+', '+', '+', '+', '+', '0', '+'}};
        int[] start6_1 = {4, 0}; // Expected output = (1, 0)
        int[] ans1 = findPassages(board1, start1_1);
        System.out.println("row" + ans1[0]);
        System.out.println("column" + ans1[1]);
        int[] ans2 = findPassages(board1, start1_2);
        System.out.println("row" + ans2[0]);
        System.out.println("column" + ans2[1]);
        int[] ans3 = findPassages(board1, start1_3);
        System.out.println("row" + ans3[0]);
        System.out.println("column" + ans3[1]);
        int[] ans4 = findPassages(board1, start1_4);
        System.out.println("row" + ans4[0]);
        System.out.println("column" + ans4[1]);
        int[] ans5 = findPassages(board2, start2_1);
        System.out.println("row" + ans5[0]);
        System.out.println("column" + ans5[1]);
        int[] ans6 = findPassages(board2, start2_2);
        System.out.println("row" + ans6[0]);
        System.out.println("column" + ans6[1]);
        int[] ans7 = findPassages(board3, start3_1);
        System.out.println("row" + ans7[0]);
        System.out.println("column" + ans7[1]);
        int[] ans8 = findPassages(board4, start4_1);
        System.out.println("row" + ans8[0]);
        System.out.println("column" + ans8[1]);
        int[] ans9 = findPassages(board5, start5_1);
        System.out.println("row" + ans9[0]);
        System.out.println("column" + ans9[1]);
        int[] ans10 = findPassages(board6, start6_1);
        System.out.println("row" + ans10[0]);
        System.out.println("column" + ans10[1]);
    }

    public static int[] findPassages(char[][] board, int[] start) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        // dfs(board, start[0], start[1], 0, visited);
        int[] ans = bfs(board, start);
        return new int[]{ans[0], ans[1]};
    }

//    public static void dfs(char[][] board, int r, int c, int steps, boolean[][] visited) {
//        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length || board[r][c] == '+' || visited[r][c])
//            return;
//        if ((r == 0 || r == board.length - 1 || c == 0 || c == board[0].length) && steps > 0) {
//            minSteps = Math.min(minSteps, steps);
//            exitIndex[0] = r;
//            exitIndex[1] = c;
//        }
//        visited[r][c] = true;
//        dfs(board, r - 1, c, steps + 1, visited);
//        dfs(board, r, c - 1, steps + 1, visited);
//        dfs(board, r + 1, c, steps + 1, visited);
//        dfs(board, r, c + 1, steps + 1, visited);
//        visited[r][c] = false;
//    }

    public static int[] bfs(char[][] board, int[] start) {
        int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int rows = board.length, columns = board[0].length;
        boolean[][] visited = new boolean[rows][columns];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{start[0], start[1], 0});
        visited[start[0]][start[1]] = true;
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int r = cell[0], c = cell[1], steps = cell[2];
            if ((r == 0 || c == 0 || r == rows - 1 || c == columns - 1) && steps > 0)
                return new int[]{r, c, steps};
            for (int[] dir : directions) {
                int newRow = r + dir[0], newCol = c + dir[1];
                if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < columns && board[newRow][newCol] == '0' && !visited[newRow][newCol]) {
                    queue.offer(new int[]{newRow, newCol, steps + 1});
                    visited[newRow][newCol] = true;
                }
            }
        }
        return new int[]{-1, -1, -1};
    }
}
