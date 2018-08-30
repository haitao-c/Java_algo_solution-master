package io.haitaoc.leetcode.recursion;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Leet_47_PermutationsII {

    private ArrayList<List<Integer>> res;
    private boolean[] used;

    public List<List<Integer>> permuteUnique(int[] nums) {

        res = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0)
            return res;

        used = new boolean[nums.length];
        LinkedList<Integer> p = new LinkedList<Integer>();
        generatePermutation(nums, 0, p);

        return res;
    }

    private void generatePermutation(int[] nums, int index, LinkedList<Integer> p) {
        if (index == nums.length) {
            if (res.contains(p))
                return;
            else
                res.add((LinkedList<Integer>) p.clone());    // 要用p的拷贝, 因为p一直再进行删除和添加操作
            return;
        }

        for (int i = 0; i < nums.length; i++) {

            if (!used[i]) {
                used[i] = true;
                p.addLast(nums[i]);
                generatePermutation(nums, index + 1, p);
                p.removeLast();     // 让p中元素一层一层出栈
                used[i] = false;    // 还原被标记过的状态
            }

        }

    }


    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        List<List<Integer>> res = new Leet_47_PermutationsII().permuteUnique(nums);
        System.out.println(res);
    }
}
