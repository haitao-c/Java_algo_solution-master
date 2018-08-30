package io.haitaoc.leetcode.dp;

import java.util.Arrays;

public class LCS {
    public int lengthOfLCS(String s1,String s2){
        if(s1==null||s2==null||s1.length()==0||s2.length()==0)
            return 0;
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m+1][n+1];
        // dp[m][n] 表示    s1中[0...m]以及s2中[0...n]处的最长公共子序列长度
        // 状态转移方程: dp[m][n] = dp[m-1][n-1]+1    if s1[m]==s2[n]
        //                        = max(dp[m-1][n],dp[m][n-1])
        Arrays.fill(dp[0],0);
        for (int i = 0; i <=m ; i++) {
            dp[i][0]=0;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <=n ; j++) {
                if(s1.charAt(i-1)==s2.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1]+1;
                else
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        return  dp[m][n];
    }

    public static void main(String[] args){
        String s1 = "ABCDE";
        String s2 = "ACBFE";
        System.out.println(new LCS().lengthOfLCS(s1,s2));
    }
}
