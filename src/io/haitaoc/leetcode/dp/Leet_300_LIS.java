package io.haitaoc.leetcode.dp;

import java.util.Arrays;

public class Leet_300_LIS {
    public int lengthOfLIS(int[] nums){
        if(nums.length==0||nums==null)
            return 0;
        int n = nums.length;
        int[] dp = new int[n];      // dp[i]表示[0...i]的最长上升子序列长度  初始值为1; 在[0...i]范围内，选择数字nums[i]可以获得的最长上升子序列的长度
        Arrays.fill(dp,1);
        for (int i = 1; i <n ; i++) {
            for (int j = 0; j < i ; j++) {
                if (nums[i]>nums[j])
                    dp[i] = Math.max(dp[i],dp[j]+1);
            }
        }
        return Arrays.stream(dp).reduce(Integer::max).getAsInt();
        /*
        for (int i = 1; i < n; i++) {
            for (int j = i-1; j >=0 ; j--) {
            错误解法   这样求得的dp[i] 不一定是最大的   从后往前找的思路错了
                if (nums[i]>nums[j]){
                    dp[i] = dp[j]+1;
                    break;
                }

            }
        }*/

    }

    public static void main(String[] args){
        int[] nums={10,9,2,5,3,7,101,18};
        System.out.println(new Leet_300_LIS().lengthOfLIS(nums));
    }
}
