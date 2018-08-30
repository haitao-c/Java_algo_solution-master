package io.haitaoc.leetcode.greedy;


import java.util.Arrays;

public class Leet_561_ArrayPartitionI {
     // [1,4,2,3]  分成[1,2] [3,4] 得4, 否则分成[1,4] [2,3] 得3, 会把较大数会被过滤
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int res = 0;
        for (int i = 0; i < nums.length; i += 2) {
            res += nums[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums={1,4,3,2};
        System.out.println(new Leet_561_ArrayPartitionI().arrayPairSum(nums));
    }
}
