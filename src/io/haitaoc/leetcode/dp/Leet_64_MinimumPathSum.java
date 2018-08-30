package io.haitaoc.leetcode.dp;

public class Leet_64_MinimumPathSum {
    //1.递归方法: 递归找出向右或向下的最小和
    //2.记忆化搜索方法：保存递归中重复计算的值即已经计算出的最小和
    //3.动态规划方法：自底向上
    public int minPathSum(int[][] grid) {
        if (grid == null) return 0;
        int m = grid.length;
        int n = grid[0].length;
        //dp[i][j]表示到第i行第j个元素处的最小和
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i==0){              // dp表中的第一行中除0号位置外其余位置处的最小和为前面最小和+当前val
                    if(j==0)
                        dp[i][j] = grid[i][j];
                    else{
                        dp[i][j] = dp[i][j-1]+grid[i][j];
                    }
                }
                else if(j==0){
                    dp[i][j]=dp[i-1][j]+grid[i][j];
                }
                else{
                    dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1])+grid[i][j];
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(grid[i][j]+" ");
            }
            System.out.println();
        }

        return dp[m-1][n-1];
    }
    public static void main(String...args){
        int[][] grid={{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(new Leet_64_MinimumPathSum().minPathSum(grid));
    }
}
