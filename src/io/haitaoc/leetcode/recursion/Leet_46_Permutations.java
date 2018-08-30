package io.haitaoc.leetcode.recursion;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Leet_46_Permutations {

    /**
     * @param nums
     * @param index
     * @param p     保存了一个有index个的元素的排列
     *              向这个排列末尾添加第index+1个元素,获得一个有index+1个元素的排列
     */
    private ArrayList<List<Integer>> res;
    private boolean[] used;

    public List<List<Integer>> permute(int[] nums) {

        res = new ArrayList<List<Integer>>();
        if(nums == null || nums.length == 0)
            return res;

        used = new boolean[nums.length];
        LinkedList<Integer> p = new LinkedList<Integer>();
        generatePermutation(nums, 0, p);

        return res;
    }

    // p中保存了一个有index-1个元素的排列。
    // 向这个排列的末尾添加第index个元素, 获得一个有index个元素的排列
    private void generatePermutation(int[] nums, int index, LinkedList<Integer> p){

        if(index == nums.length){
            res.add((LinkedList<Integer>)p.clone());    // 要用p的拷贝, 因为p一直再进行删除和添加操作
            return;
        }

        for(int i = 0 ; i < nums.length ; i ++)
            if(!used[i]){
                used[i] = true;
                p.addLast(nums[i]);
                generatePermutation(nums, index + 1, p );
                p.removeLast();     // 让p中元素一层一层出栈
                used[i] = false;    // 还原被标记过的状态
            }
    }

    private static void printList(List<Integer> list){
        for(Integer e: list)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 3};
        List<List<Integer>> res = (new Leet_46_Permutations()).permute(nums);
        for(List<Integer> list: res)
            printList(list);
    }

}
