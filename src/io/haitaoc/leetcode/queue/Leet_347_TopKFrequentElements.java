package io.haitaoc.leetcode.queue;

import java.util.*;

public class Leet_347_TopKFrequentElements {

    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i <nums.length ; i++) {
            if(!map.containsKey(nums[i]))
                map.put(nums[i],1);
            else
                map.put(nums[i],map.get(nums[i])+1);
        }
        // 创建大顶堆, size超过k后的小元素会被挤出
        Queue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>(k,
                (Map.Entry<Integer,Integer> a,Map.Entry<Integer,Integer> b)->(b.getValue()-a.getValue())
        );
        List<Integer> res = new ArrayList<>();

        for (Map.Entry<Integer,Integer> entry:map.entrySet()){
            pq.offer(entry);
        }

        for (int i = 0; i <k ; i++) {
            res.add(pq.poll().getKey());
        }

        return res;
    }

    public static void main(String[] args){
        int[] nums = {1,1,1,2,2,3};
        int k = 2;
        System.out.println(new Leet_347_TopKFrequentElements().topKFrequent(nums,k));
    }
}
