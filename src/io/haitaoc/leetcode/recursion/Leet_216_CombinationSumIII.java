package io.haitaoc.leetcode.recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Leet_216_CombinationSumIII {

    ArrayList<List<Integer>> res;
    boolean[] used;

    public List<List<Integer>> combinationSum3(int k, int n) {
        res = new ArrayList<>();

        if (n < k)
            return res;
        if (n == 0 && k == 1)
            return res;

        used = new boolean[10];

        LinkedList<Integer> p = new LinkedList<>();

        combination(k, n, p);

        return res;

    }

    private void combination(int k, int remain, LinkedList p) {
        if (remain < 0 || p.size() > k)
            return;
        if (remain == 0 && p.size() == k) {
            // 先对子集合排序, 然后通过contains方法去重
            LinkedList<Integer> pClone = (LinkedList<Integer>) p.clone();
            Collections.sort(pClone);
            if (!res.contains(pClone)) {
                res.add(pClone);
                return;
            }
        }

        for (int i = 1; i <= 9; i++) {
            if(!used[i]){
                used[i]= true;
                p.addLast(i);
                combination(k, remain - i, p);
                p.removeLast();         // 回溯, 恢复状态
                used[i] = false;
            }

        }
    }

    public static void main(String[] args) {
        int k = 3, n = 9;
        System.out.println(new Leet_216_CombinationSumIII().combinationSum3(k, n));
    }
}
