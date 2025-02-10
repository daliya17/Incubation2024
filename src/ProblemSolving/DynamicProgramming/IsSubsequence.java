package ProblemSolving.DynamicProgramming;

public class IsSubsequence {
    public static void main(String[] args){
        System.out.println(isSubsequence("abc","ahbgdc"));
    }

    public static boolean isSubsequence(String s, String t) {
        int n=s.length(), m=t.length();
        boolean[][] dp = new boolean[n+1][m+1];
        for(int i=0;i<=m;i++){
            dp[0][i]=true;
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(s.charAt(i-1)==t.charAt(j-1))
                    dp[i][j]=dp[i-1][j-1];
                else
                    dp[i][j] = dp[i][j-1];
            }
        }
        return dp[n][m];
    }
}
