package io.haitaoc.leetcode.recursion;

import java.util.*;

public class Leet_78_Subsets {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> temp = new ArrayList<Integer>();
        dfs(res, temp, nums, 0);
        return res;
    }
    private void dfs(List<List<Integer>> res, List<Integer> temp, int[] nums, int j) {
        res.add(new ArrayList<Integer>(temp));
        for(int i = j; i < nums.length; i++) {
            temp.add(nums[i]);  //① 加入 nums[i]
            dfs(res, temp, nums, i + 1);  //② 递归
            temp.remove(temp.size() - 1);  //③ 移除 nums[i]
        }
    }


//    ArrayList<List<Integer>> res;
//    boolean[] used;
//
//    public List<List<Integer>> subsets(int[] nums) {
//        res = new ArrayList<>();
//        if (nums == null || nums.length == 0)
//            return res;
//
//        used = new boolean[nums.length];
//        LinkedList<Integer> p = new LinkedList<>();
//        res.add(p);
//        subset(nums, p);
//
//        return res;
//    }
//
//    private void subset(int[] nums, LinkedList<Integer> p) {
//        if (p.size() > nums.length)
//            return;
//
//        // 先对子集合排序, 然后通过contains方法去重
//        LinkedList<Integer> pClone = (LinkedList<Integer>) p.clone();
//        Collections.sort(pClone);
//
//        if (!res.contains(pClone)) {
//            res.add(pClone);
//            return;
//        }
//
//
//        for (int i = 0; i < nums.length; i++) {
//            if (!used[i]) {
//                used[i] = true;
//                p.addLast(nums[i]);
//                if(p.size()==1){
//                    res.add((LinkedList<Integer>) p.clone());
//                }
//                subset(nums, p);
//                p.removeLast();
//                used[i] = false;
//            }
//        }
//    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(new Leet_78_Subsets().subsets(nums));
    }
}
