package io.haitaoc.leetcode.dp;

/**
 * There are two kinds of wiggle subseq which end in number. sine and cosine。
 *
 * For i, j and 0 <= j < i,
 * sine，nums[i]-nums[j] > 0, sin[i] depends on cos[j]
 * cosine，nums[i]-nums[j] < 0, cos[i] depends on sin[j]
 *
 * sin[i] = argmax{cos[j]+1}
 * cos[i] = argmax{sin[j]+1}
 */

public class Leet_376_WiggleSubsequence {
    public int wiggleMaxLength(int[] nums) {
        if (nums==null||nums.length==0)
            return 0;
        int len = nums.length;
        int[] up = new int[len];
        int[] down = new int[len];
        int max = 0;
        for (int i=0; i<len; i++) {
            up[i] = 1;
            down[i] = 1;
            for (int j=i-1; j>=0; j--) {
                if (nums[i]-nums[j] > 0) {
                    up[i] = Math.max(up[i], 1+down[j]);
                }
                if (nums[i]-nums[j] < 0 ) {
                    down[i] = Math.max(down[i], 1+up[j]);
                }
            }
            max = Math.max(max, Math.max(up[i], down[i]));
        }
        return max;

    }
    public static void main(String[] args){
        int[] nums={1,17,5,10,13,15,10,5,16,8};
        System.out.println(new Leet_376_WiggleSubsequence().wiggleMaxLength(nums));
    }
}
