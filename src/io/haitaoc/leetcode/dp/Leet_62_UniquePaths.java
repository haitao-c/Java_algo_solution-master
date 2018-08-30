package io.haitaoc.leetcode.dp;

public class Leet_62_UniquePaths {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[n+1][m+1];
        for (int i = 1; i <=m ; i++) {
            dp[0][i] = 1;
            dp[1][i] = 1;
        }
        for (int i = 1; i <= n; i++) {
            dp[i][0] = 1;
            dp[i][1] = 1;
        }
        for (int i = 2; i <=n ; i++) {
            for (int j = 2; j <=m ; j++) {
                dp[i][j] =  dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[n][m];
    }
    public static void main(String...args){
        System.out.println(new Leet_62_UniquePaths().uniquePaths(7,3));
    }
}
