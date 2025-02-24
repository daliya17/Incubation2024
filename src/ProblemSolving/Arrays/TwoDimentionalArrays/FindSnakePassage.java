package ProblemSolving.Arrays.TwoDimentionalArrays;

import java.util.ArrayList;
import java.util.List;

public class FindSnakePassage {
    public static void main(String[] args) {
        char[][] board1 = new char[][]{{'+', '+', '+', '+', '+', '+', '+', '0', '0'},
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
    }

    public static List<Integer> findPassages(char[][] board, int[] start) {
        List<Integer> ans = new ArrayList<>();
        passage(board, start[0], start[1]);
        return ans;
    }

    public static int passage(char[][] board, int i, int j) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length)
            return 0;
        if (board[i][j] == '+')
            return -1;
        int right = passage(board, i, j + 1);
        int min = 0;
        if (right > 0)
            min = right;
        int left = passage(board, i, j - 1);
        if (left > 0)
            min = Math.min(left, right);
        int down = passage(board, i + 1, j);
        if (down > 0)
            min = Math.min(min, down);
        int up = passage(board, i - 1, j);
        if (up > 0)
            min = Math.min(min, up);
        return min;
    }
}
