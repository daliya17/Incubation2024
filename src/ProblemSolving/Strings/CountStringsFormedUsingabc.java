package ProblemSolving.Strings;

public class CountStringsFormedUsingabc {
    public static void main(String[] args) {
        System.out.println(countStrings(3,1,2));
        System.out.println(countStrings(4,1,2));
    }

    // use b only once, use a any number of times, use c atmost 2 times
    // using combinations
    // arrange n objects , p of one type, q of another type, r of another type
    // n!/(p!*q!*r!)
    // strings with no b and c, n!/(n-0)!*0!*0! = 1
    // strings with 1 b and no c, n!/(n-1)!*1!*0! = n
    // strings with 0 b and 1 c, n!/(n-1)!*0!*1! = n
    // strings with 0 b and 2 c, n!/(n-2)!*0!*2! = n*(n-1)/2
    // string with 1b and 1c, n!/(n-2)!*1!*1! = n*(n-1)
    // string with 1b and 2c, n!/(n-3)!*1!*2! = n*(n-1)*(n-2)/2
    public static int countStrings(int n, int b, int c) {
      //  return 1 + (2 * n) + ((n * (n - 1)) / 2) + (n * (n - 1)) + ((n * (n - 1) * (n - 2)) / 2);
        // using dynamic programming
        int[][][] dp = new int[n+1][2][3];
        for(int i=0;i<n+1;i++){
            for(int j=0;j<2;j++){
                for(int k=0;k<3;k++){
                    dp[i][j][k]=-1;
                }
            }
        }
        return countstringUtil(n,b,c,dp);
    }

    public static int countstringUtil(int n, int b, int c, int[][][] dp){
        if(b<0||c<0)
            return 0;
        if(n==0)
            return 1;
        if(dp[n][b][c]!=-1)
            return dp[n][b][c];
        int ans=0;
        // n decreases by 1,no b or c case
        ans+=countStrings(n-1,b,c);
        // atleast one b case
        ans+=countStrings(n-1,b-1,c);
        // atleast one c case
        ans+=countStrings(n-1,b,c-1);
        return dp[n][b][c]=ans;
    }
    // using dynamic programming, time complexity: O(n) because we are calculating for n only once
    // space complexity: O(n), because we are storing the results for n only once
    // bottom up approach is when we start from the base case and go till the end case, here we are starting from the end case and going till the base case
    // top down approach is when we start from the end case and go till the base case
    // bottom up approach is better than top down approach because we are not calculating the same values again and again
// in top down, we use recursion and in bottom up, we use iteration
    // top down also called as memoization and bottom up also called as tabulation

}
