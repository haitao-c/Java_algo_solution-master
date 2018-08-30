package io.haitaoc.leetcode.recursion;

import java.util.*;

public class Leet_39_CombinationSum {


    List<List<Integer>> res;


    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new ArrayList<List<Integer>>();
        if (candidates.length == 0 || candidates == null)
            return res;

        LinkedList<Integer> p = new LinkedList<Integer>();

        generateCombinationSum(candidates, target, p);

        return res;


    }

    private void generateCombinationSum(int[] candidates, int target, LinkedList<Integer> p) {
        if (sum(p) > target)
            return;
        if (sum(p) == target){
            // 先对子集合排序, 然后通过contains方法去重
            LinkedList<Integer> pClone=(LinkedList<Integer>)p.clone();
            Collections.sort(pClone);
            if (!res.contains(pClone)) {
                res.add(pClone);
                return;
            }
        }

        for (int i = 0; i < candidates.length; i++) {
            p.addLast(candidates[i]);
            generateCombinationSum(candidates,target,p);
            p.removeLast();             // 回溯
        }
    }

    private int sum(LinkedList<Integer> p) {
        int sum = 0;
        for (int num : p)
            sum += num;
        return sum;
    }


    public static void main(String[] args) {
        int[] candidates={2,3,5};
        int target = 8;
        System.out.println(new Leet_39_CombinationSum().combinationSum(candidates,target));
    }
}
