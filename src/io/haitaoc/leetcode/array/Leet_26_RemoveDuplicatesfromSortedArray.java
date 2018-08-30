package io.haitaoc.leetcode.array;

public class Leet_26_RemoveDuplicatesfromSortedArray {
    public int removeDuplicates(int[] nums) {
        int k = 1;          // nums[0...k)中均为非重复元素
        for (int i = 1; i <nums.length ; i++) {
            if(nums[i]>nums[k-1])
                nums[k++] = nums[i];
        }
        return k;
    }
    public static void main(String[] args){
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(new Leet_26_RemoveDuplicatesfromSortedArray().removeDuplicates(nums));
        for(int a:nums)
            System.out.print(a+" ");
    }

}
