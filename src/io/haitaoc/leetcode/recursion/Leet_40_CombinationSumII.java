package io.haitaoc.leetcode.recursion;

import sun.awt.image.ImageWatched;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Leet_40_CombinationSumII {

    ArrayList<List<Integer>> res;
    boolean[] used;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res = new ArrayList<>();
        if(candidates==null||candidates.length==0)
            return res;
        used = new boolean[candidates.length];
        LinkedList<Integer> p = new LinkedList<>();
        generateCombination(candidates,target,p);
        return res;
    }

    private void generateCombination(int[] candidates, int remain, LinkedList p){
        if(remain<0)
            return ;
        if(remain==0){
            // 先对子集合排序, 然后通过contains方法去重
            LinkedList<Integer> pClone=(LinkedList<Integer>)p.clone();
            Collections.sort(pClone);
            if (!res.contains(pClone)) {
                res.add(pClone);
                return;
            }
        }

        for (int i = 0; i < candidates.length ; i++) {
            if(!used[i]){
                used[i] = true;
                p.addLast(candidates[i]);
                generateCombination(candidates,remain-candidates[i],p);
                p.removeLast();
                used[i] = false;
            }
        }

    }


    public static void main(String[] args) {
        int[] candidates = {2,5,2,1,2};
        int target = 5;
        System.out.println(new Leet_40_CombinationSumII().combinationSum2(candidates,target));
    }
}
