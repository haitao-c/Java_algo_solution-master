package io.haitaoc.leetcode.search;


import java.util.HashSet;
import java.util.Set;

public class Leet_349_IntersectionOfTwoArrays {

    public int[] intersection(int[] nums1, int[] nums2) {
        if(nums1==null||nums2==null)
            return null;
        // 结果也用set记录, 因为每个元素只希望记录一次
        Set<Integer> resultSet = new HashSet<>();
        Set<Integer> hashSet = new HashSet<Integer>();
        for(int i:nums1)
            hashSet.add(i);
        for(int i:nums2)
            if(hashSet.contains(i))
                resultSet.add(i);
        int[] result = new int[resultSet.size()];
        Integer[] temp = new Integer[resultSet.size()];
        resultSet.toArray(temp);
        for (int i = 0; i <temp.length ; i++) {
            result[i] = temp[i];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        new Leet_349_IntersectionOfTwoArrays().intersection(nums1,nums2);
    }

}
