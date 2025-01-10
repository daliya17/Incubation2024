package ProblemSolving.Arrays;

import java.util.ArrayList;
import java.util.List;

public class TripletsWithSumZero {
    public static void main(String[] args) {
        int[] arr = {0, -1, 2, -3, 1};
        System.out.println(tripletsWithSumZero(arr));
    }

    public static List<List<Integer>> tripletsWithSumZero(int[] arr) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < arr.length - 2; i++) {
            for (int j = i + 1; j < arr.length - 1; j++) {
                for (int k = j + 1; k < arr.length; k++) {
                    if (arr[i] + arr[j] + arr[k] == 0) {
                        ans.add(List.of(i, j, k));
                    }
                }
            }
        }
//         nested loops are used to get all the possible combinations of 3 elements
//         and check if their sum is zero
//         Time complexity of this approach is O(n^3)
        return ans;

        // Better approach
        // Time complexity of this approach is O(n^2)
        // Space complexity of this approach is O(n)
//         int n = arr.length;
//        for (int i = 0; i < n - 2; i++) {
//            int l = i + 1;
//            int r = n - 1;
//            while (l < r) {
//                if (arr[i] + arr[l] + arr[r] == 0) {
//                    ans.add(List.of(arr[i], arr[l], arr[r]));
//                    l++;
//                    r--;
//                } else if (arr[i] + arr[l] + arr[r] < 0) {
//                    l++;
//                } else {
//                    r--;
//                }
//            }
//    }
}}
