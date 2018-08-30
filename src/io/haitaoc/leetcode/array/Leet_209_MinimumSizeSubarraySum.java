package io.haitaoc.leetcode.array;

public class Leet_209_MinimumSizeSubarraySum {

    public int minSubArrayLen(int s, int[] nums) {
        int l = 0, r = -1;       // nums[l...r] 为滑动窗口大小
        int sum = 0;
        int res = nums.length + 1;

        while (l < nums.length) {
            if (sum < s && r + 1 < nums.length) {
                sum += nums[++r];
            } else
                sum -= nums[l++];
            if(sum>=s)
                res = Math.min(res,r-l+1);
        }

        if(res==nums.length+1)
            return 0;

        return res;
    }

}
