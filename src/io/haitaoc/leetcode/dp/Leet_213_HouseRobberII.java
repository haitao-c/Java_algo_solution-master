package io.haitaoc.leetcode.dp;


public class Leet_213_HouseRobberII {
    public int rob(int[] nums){
        if(nums==null||nums.length==0)
            return 0;
        int n = nums.length;
        // dp[i] 表示[0...i]处所抢劫到的最大值
        if(n==1) return nums[0];
        return Math.max(rob(nums, 0, nums.length - 2), rob(nums, 1, nums.length - 1));

    }
    private int rob(int[] nums,int left,int right) {
        int n=nums.length;
        int[] dp = new int[n];

        for (int i = left; i <= right; i++) {
            if (i == left) {
                dp[i] = nums[i];
            }
            else if (i == left + 1) {
                dp[i] = Math.max(nums[i - 1], nums[i]);
            }
            else {
                dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
            }
        }
        return dp[right];

    }

    public static void main(String... args) {
        int[] nums = {1,2,3,1};
        System.out.println(new Leet_213_HouseRobberII().rob(nums));
    }
}
