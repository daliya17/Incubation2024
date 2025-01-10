package ProblemSolving.Strings;

import java.util.Arrays;
import java.util.HashSet;

public class DistinctPalindromes {
    public static void main(String[] args) {
        String s = "aabaa";
        System.out.println(countDistinctPalindromes(s));
    }
    public static int countDistinctPalindromes(String s){
        int n = s.length();
        int count=0;
        int[][] dp = new int[n][n];
        for(int[] row: dp){
            Arrays.fill(row, -1);
        }

        HashSet<String> set = new HashSet<>();
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(isPalindrome(i,j,dp,s)==1){
                    set.add(s.substring(i,j+1));
                }
            }
        }
        System.out.println(set);
        for(int i=0;i<n;i++){
            set.add(s.charAt(i)+"");
        }
        System.out.println(set);
        return set.size();
    }

    public static int isPalindrome(int i, int j, int[][] arr, String s){
        if(i==j){
            return 1;
        }
        boolean b = s.charAt(i) == s.charAt(j);
        if(j==i+1 && b){
            return 1;
        }
        if(arr[i][j]!=-1){
            return arr[i][j];
        }
        if (b && isPalindrome(i + 1, j - 1, arr, s) == 1) {
            return arr[i][j] = 1;
        }
        else {
             arr[i][j] = 0;
        }
        return arr[i][j];
    }

//    static int isPalindrome(int i, int j, String s,
//                            int[][] memo) {
//
//        // One length string is always palindrome
//        if (i == j)
//            return 1;
//
//        // Two length string is palindrome if
//        // both characters are same
//        if (j == i + 1 && s.charAt(i) == s.charAt(j))
//            return 1;
//
//        // if current substring is already checked
//        if (memo[i][j] != -1)
//            return memo[i][j];
//
//        // Check if the characters at i and j are equal
//        // and the substring inside is palindrome
//        if(s.charAt(i) == s.charAt(j) &&
//                isPalindrome(i + 1, j - 1, s, memo) == 1)
//            memo[i][j] = 1;
//        else
//            memo[i][j] = 0;
//
//        return memo[i][j];
//    }
//
//    static int countPS(String s) {
//        int n = s.length();
//
//        // Memoization table
//        int[][] memo = new int[n][n];
//        for (int[] row : memo) {
//            Arrays.fill(row, -1);
//        }
//        HashSet<String> set = new HashSet<>();
//
//
//        int res = 0;
//        for (int i = 0; i < n; i++) {
//            for (int j = i + 1; j < n; j++) {
//
//                // Check if the substring is palindrome
//                if (isPalindrome(i, j, s, memo) == 1) {
//                    set.add(s.substring(i, j + 1));
//                }
//            }
//        }
//        System.out.println(set);
//        for(int i=0;i<n;i++){
//            set.add(s.charAt(i)+"");
//        }
//        System.out.println(set);
//
//        return set.size();
//    }
//
//    public static void main(String[] args) {
//        String s = "aabaa";
//        System.out.println(countPS(s));
//    }
}
