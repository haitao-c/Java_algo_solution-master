package io.haitaoc.leetcode.dp;

public class Leet_198_HouseRobber {
    public int rob(int[] nums) {
        if(nums==null||nums.length==0)
            return 0;
        int n = nums.length;
        // dp[i] 表示[0...i]处所抢劫到的最大值
        int[] dp = new int[n];
        dp[0] = nums[0];
        if(n==1) return dp[0];
        if(n==2) return Math.max(nums[0],nums[1]);
        dp[1] = Math.max(nums[0],nums[1]);
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i-1],dp[i-2]+nums[i]);
        }
        return dp[n - 1];
    }
    public static void main(String... args) {
        int[] nums = {1,2,3,1};
        System.out.println(new Leet_198_HouseRobber().rob(nums));
    }
}
