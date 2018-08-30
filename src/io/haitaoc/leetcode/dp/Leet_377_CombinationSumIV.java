package io.haitaoc.leetcode.dp;

import java.util.Arrays;

public class Leet_377_CombinationSumIV {
    // 假设给定的nums为num1, num2...numn，用dp[i]表示组成i的组合个数，如果i>=numj, 那么
    // dp[i] = dp[i-num1]+dp[i-num2]+...dp[i-numj]

    public int combinationSum4(int[] nums, int target){
        if(target<=0||nums==null||nums.length==0)
            return 0;
        int[] dp = new int[target+1];
        Arrays.fill(dp,0);
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for(int n:nums)
                if(n<=i)
                    dp[i]+=dp[i-n];
        }
        return dp[target];
    }
    // 错解成完全背包问题
    // 不能用完全背包解的原因: [1,2,1]和[1,1,2]是不同的
    public int wrongCombinationSum4(int[] nums, int target) {
        if(target<=0||nums==null||nums.length==0)
            return 0;
        int n = nums.length;
        int[][] dp = new int[n][target+1];
        dp[0][0] = 0;
        for (int i = 1; i <= target; i++) {
            if(i%nums[0]==0)
                dp[0][i] = i/nums[0];
        }
        for (int i = 1; i <n ; i++) {
            dp[i][0] = 0;
        }
        for (int i = 1; i <n ; i++) {
            for (int j = 1; j <=target ; j++) {
                if (j>=nums[i])
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-nums[i]]+1);
                else
                    dp[i][j] = dp[i-1][j];
            }
        }
        return dp[n-1][target];

    }
    public static void main(String... args) {
        int[] nums = {1,2,3};
        int target = 4;
        System.out.println(new Leet_377_CombinationSumIV().combinationSum4(nums,target));
    }
}
