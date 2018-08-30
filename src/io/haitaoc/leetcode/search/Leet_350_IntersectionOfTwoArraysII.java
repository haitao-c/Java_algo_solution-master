package io.haitaoc.leetcode.search;

import io.haitaoc.util.PrintArray;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Leet_350_IntersectionOfTwoArraysII {
    // 分别map1和map2存储nums1和nums2中所有元素及出现的对应次数
    // 再取两map中出现次数较少的，且根据出现次数将元素放入list中
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1==null||nums2==null)
            return null;
        if(nums1.length==0||nums2.length==0)
            return new int[]{};
        Map<Integer,Integer> map1 = new HashMap<>();
        Map<Integer,Integer> map2 = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int i:nums1)
            if(!map1.containsKey(i))
                map1.put(i,1);
            else
                map1.put(i,map1.get(i)+1);
        for (int i:nums2)
            if(!map2.containsKey(i))
                map2.put(i,1);
            else
                map2.put(i,map2.get(i)+1);
        for (Map.Entry<Integer, Integer> entry : map1.entrySet()) {
            int key = entry.getKey();
            int entryTimes = entry.getValue();
           if(map2.containsKey(key)){
               int times = map2.get(key)>entryTimes?entryTimes:map2.get(key);
               for (int i = 0; i <times ; i++) {
                   list.add(key);
               }
           }
        }
        Integer[] temp = new Integer[list.size()];
        int[] result = new int[list.size()];
        list.toArray(temp);
        for (int i = 0; i < temp.length; i++) {
            result[i] = temp[i];
        }
        return result;

    }

    public static void main(String[] args) {
        int[] nums1 = {};
        int[] nums2 = {};
        PrintArray.print(new Leet_350_IntersectionOfTwoArraysII().intersect(nums1,nums2));

    }

}
