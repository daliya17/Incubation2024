public class LongestCommonSubsequence {
    public static void main(String[] args) {
        System.out.println(longestSubSequence("cbbd"));
    }

    public static int longestSubSequence(String s) {
        return getCommonSubsequence(s, reverse(s));
    }

    public static int getCommonSubsequence(String s1, String s2) {
        int n = s1.length();
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++)
            dp[0][i] = 0;
        for (int i = 0; i < n; i++)
            dp[i][0] = 0;
        if(s1.charAt(0)==s2.charAt(0))
            dp[0][0]=1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (s1.charAt(i) == s2.charAt(j) && i > 0 && j > 0)
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else {
                    if (i > 0)
                        dp[i][j] = dp[i - 1][j];
                    if (j > 0)
                        dp[i][j] = Math.max(dp[i][j - 1], dp[i][j]);
                }
            }
        }
        return dp[n - 1][n - 1];
    }

    public static String reverse(String s) {
        StringBuilder s1 = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--)
            s1.append(s.charAt(i));
        return s1.toString();
    }
}
