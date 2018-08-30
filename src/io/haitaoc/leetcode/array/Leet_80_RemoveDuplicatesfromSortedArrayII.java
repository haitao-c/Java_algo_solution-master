package io.haitaoc.leetcode.array;

public class Leet_80_RemoveDuplicatesfromSortedArrayII {
    public int removeDuplicates(int[] nums) {
        int k = 1;
        int count = 1;
        for (int i = 1; i < nums.length ; i++) {
            if(nums[i]>nums[k-1]){
                nums[k++] = nums[i];
                count = 1;
            }else if(nums[i]==nums[k-1]){
                if(count==1)
                    nums[k++]=nums[i];
                count++;
            }
        }
        return k;
    }

    public static void main(String[] args){
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(new Leet_80_RemoveDuplicatesfromSortedArrayII().removeDuplicates(nums));
        for(int a:nums)
            System.out.print(a+" ");
    }
}
