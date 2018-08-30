package io.haitaoc.leetcode.array;

public class Leet_167_TwoSumII {
    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length - 1; i++) {
            int j = binarySearch(numbers, i + 1, numbers.length - 1, target - numbers[i]);
            if (j != -1) {
                int[] res = {i + 1, j + 1};
                return res;
            }
        }
        throw new IllegalStateException("The input has no solution");
    }


    private int binarySearch(int[] nums, int l, int r, int target){

        if(l < 0 || l > nums.length)
            throw new IllegalArgumentException("l is out of bound");

        if(r < 0 || r > nums.length)
            throw new IllegalArgumentException("r is out of bound");

        while(l <= r){
            int mid = l + (r - l)/2;
            if(nums[mid] == target)
                return mid;
            if(target > nums[mid])
                l = mid + 1;
            else
                r = mid - 1;
        }

        return -1;
    }

    private static void printArr(int[] nums){
        for(int num: nums)
            System.out.print(num + " ");
        System.out.println();
    }

    public static void main(String[] args) {

        int[] nums = {2, 7, 11, 15};
        int target = 9;
        printArr(new Leet_167_TwoSumII().twoSum(nums, target));
    }
}
