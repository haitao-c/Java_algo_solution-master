package io.haitaoc.leetcode.recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Leet_90_SubsetsII {
    boolean [] used;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> p = new LinkedList<>();
        if(nums.length==0||nums==null)
            return res;
        used = new boolean[nums.length];
        dfs(nums,0,p,res);
        return res;
    }


    private void dfs(int[] nums,int index, LinkedList<Integer> p, List<List<Integer>> res){
        // 先对子集合排序, 然后通过contains方法去重
        LinkedList<Integer> pClone=(LinkedList<Integer>)p.clone();
        Collections.sort(pClone);
        if (!res.contains(pClone))
            res.add(pClone);
        for (int i = index; i <nums.length ; i++) {
            if(!used[i]){
                used[i]=true;
                p.addLast(nums[i]);
                dfs(nums,index+1,p,res);
                p.removeLast();
                used[i]=false;
            }

        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(new Leet_90_SubsetsII().subsetsWithDup(nums));
    }

}
