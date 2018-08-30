package io.haitaoc.leetcode.search;

import java.util.HashMap;

public class Leet_1_TwoSums {

    public int[] twoSum(int[] nums, int target) {

        int[] res = new int[2];
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i <nums.length ; i++) {
            if(map.containsKey(target-nums[i])){
                res[0]=i;
                res[1]=map.get(target-nums[i]);
                return res;
            }
            map.put(nums[i],i);

        }
        return res;

    }

    public static void printArr(int[] arr){
        for (int a:arr) {
            System.out.print(a+" ");
        }

    }
    public static void main(String[] args) {

        int[] nums={2, 7, 11, 15};
        int target = 9;
        printArr(new Leet_1_TwoSums().twoSum(nums,target));
    }
}
