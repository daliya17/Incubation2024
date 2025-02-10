package ProblemSolving.DynamicProgramming;

public class DecodeWays {
    public static void main(String[] args) {
        System.out.println(ways("06"));
    }

    public static int ways(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        for (int i = 0; i <= n; i++)
            dp[i] = 0;
        if (s.charAt(0) != '0')
            dp[1] = 1;
        if (s.length() > 1) {
            if (s.charAt(1) != '0')
                dp[2] = dp[1];
            if (s.charAt(0) == '1' || (s.charAt(0) == '2' && Integer.parseInt(String.valueOf(s.charAt(1))) <= 6)) {
                dp[2]++;
            }
        }
        for (int i = 3; i <= n; i++) {
            int val = Integer.parseInt(String.valueOf(s.charAt(i - 1)));
            if (val > 0 && val < 27) {
                dp[i] = dp[i - 1];
            }
            if (s.charAt(0) == '1' || (s.charAt(0) == '2' && Integer.parseInt(String.valueOf(s.charAt(1))) <= 6)) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[n];
    }

}
