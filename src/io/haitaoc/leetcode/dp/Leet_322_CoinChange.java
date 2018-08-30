package io.haitaoc.leetcode.dp;

public class Leet_322_CoinChange {
    //1. dp[i][j]表示使得用[0...i]的硬币构成总额为j的最小硬币数
    //   状态转移方程: dp[i][j] = dp[i-1][j]
    //                         = dp[i][j-coins[i]]+1
    /**
     * 解释为什么不是dp[i][j] = Math.min(dp[i-1][j],dp[i][j-coins[i]+1],dp[i][j-2*coins[i]]+2...dp[i][j-k*coins[i]]+k)
     * 1.dp[i][j] = Math.min(dp[i-1][j],dp[i][j-coins[i]]+1)
     * 2.dp[i][j-coins[i]] = Math.min(dp[i-1][j-coins[i],dp[i][j-coins[i]-coins[i]]+1)
     * 2式两边同时+1得
     * dp[i][j-coins[i]] = Math.min(dp[i-1][j-coins[i]+1,dp[i][j-2*coins[i]]+2)
     * 所以 dp[j-coins[i]] + 1 <= dp[j-2coins[i]] + 2 一定成立
     */
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0 || amount < 0)
            return -1;
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];
        dp[0][0] = 0;
        for (int i = 1; i <= amount; i++) {
            if (i % coins[0] == 0)
                dp[0][i] = i / coins[0];
            else
                dp[0][i] = Integer.MAX_VALUE - 1;
        }
        for (int i = 1; i < n; i++) {
            dp[i][0] = 0;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= amount; j++) {
                if(j>=coins[i])
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - coins[i]] + 1);
                else
                    dp[i][j] = dp[i-1][j];
            }
        }
        return dp[n - 1][amount]==Integer.MAX_VALUE-1?-1:dp[n - 1][amount];
    }
    // 2. 一维数组解决
    public int coinChange2(int[] coins, int amount) {

        int[] dp = new int[amount+1];
        dp[0] = 0;
        for (int i = 1; i < amount+1; i++) {
            dp[i] = Integer.MAX_VALUE - 1;
        }

        for(int i = 0 ; i < coins.length ; i++){
            for (int j = 1; j < amount+1; j++) {
                if(j - coins[i] >= 0){
                    //dp[j] here represents the fewest number of coins to make up amount (j) using coins[0],coins[1],...,coins[i]
                    dp[j] = Math.min(dp[j],dp[j-coins[i]] + 1);
                }
            }
        }

        if(dp[amount] == Integer.MAX_VALUE-1)
            return -1;

        //finally dp[amount] represents the fewest number of coins to make up amount (amount) using coins[0],coins[1],...,coins[n]
        return dp[amount];
    }

    public static void main(String... args) {
        int[] coins = {2};
        int amount = 1;
        System.out.println(new Leet_322_CoinChange().coinChange(coins, amount));
    }
}
