package io.haitaoc.leetcode.array;

public class Leet_713_SubarrayProductLessThanK {

    /**
     The idea is always keep an max-product-window less than K;
     Every time shift window by adding a new number on the right(j), if the product is greater than k, then try to reduce numbers on the left(i), until the subarray product fit less than k again, (subarray could be empty);
     Each step introduces x new subarrays, where x is the size of the current window (j + 1 - i);
     example:
     for window (5, 2), when 6 is introduced, it add 3 new subarray: (5, (2, (6)))
     */

    public int numSubarrayProductLessThanK2(int[] nums, int k) {
        if (k == 0) return 0;
        int cnt = 0;
        int pro = 1;
        for (int i = 0, j = 0; j < nums.length; j++) {
            pro *= nums[j];
            while (i <= j && pro >= k) {
                pro /= nums[i++];
            }
            cnt += j - i + 1;
        }
        return cnt;
    }

    public int numSubarrayProductLessThanK(int[] nums, int k) {

        if (k <= 0)
            return 0;

        int res = 0;

        int l = 0, r = 0; // sliding windos nums[l, r)
        int prod = 1;
        while (l < nums.length) {

            if (r < nums.length && prod * nums[r] < k) {
                prod *= nums[r];
                r++;
            } else if (l == r) { // nums[l] >= k
                l++;
                r++;
            } else { // r >= nums.size() || prod * nums[r] >= k
                res += (r - l);
                prod /= nums[l];
                l++;
            }
        }

        return res;
    }


    public static void main(String[] args) {

        int[] nums = {10, 9, 10, 4, 3, 8, 3, 3, 6, 2, 10, 10, 9, 3};
        int k = 19;

        System.out.println(new Leet_713_SubarrayProductLessThanK().numSubarrayProductLessThanK(nums, k));
    }
}
