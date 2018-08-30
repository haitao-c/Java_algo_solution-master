package io.haitaoc.leetcode.dp;

import java.util.ArrayList;
import java.util.Arrays;


public class Leet_673_NumberOfLIS {

    public int findNumberOfLIS(int[] nums) {
            if(nums == null || nums.length == 0) return 0;

            int dp[] = new int[nums.length];
            int count[] = new int[nums.length];
            Arrays.fill(count,1);
            Arrays.fill(dp,1);
            int max = 1;
            for(int i = 0; i < nums.length; i++){
                for(int j = 0; j < i; j++){
                    if(nums[i] > nums[j]) {
                        if(dp[i] < dp[j] +1){
                            dp[i] = dp[j]+1;
                            count[i] = count[j];
                        }
                        else if(dp[i] == dp[j]+1) {
                            count[i] += count[j];
                        }
                    }
                }
                max = Math.max(max,dp[i]);
            }

            int res = 0;
            for(int i = 0; i < dp.length; i++){
                if(dp[i] == max) res += count[i];
            }

            return res;
        }


    public static void main(String[] args) {
        int[] nums1 = {1, 3, 5, 4, 7};
        int[] nums = {2,2,2,2,2};
        System.out.println(new Leet_673_NumberOfLIS().findNumberOfLIS(nums));
    }
}
