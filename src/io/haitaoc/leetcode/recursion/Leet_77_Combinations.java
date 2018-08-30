package io.haitaoc.leetcode.recursion;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Leet_77_Combinations {
    List<List<Integer>> res;

    // 求解C(n,k), 当前已经找到的组合存储在c中, 需要从start开始搜索新的元素
    private void generateCombinations(int n, int k, int start, LinkedList<Integer> c) {

        if (c.size() == k) {
            // 此处add方法传递的是LinkedList c的拷贝, 因为c本身的内容一直在变化, 所以传递拷贝, 获得完整的内容
            res.add((List<Integer>) c.clone());
            return;
        }

        // k-c.size()个空位,[i...n]中至少偶k-c.size()个元素
        // i 最多为 n-(k-c.size()) + 1
        for (int i = start; i <= n; i++) {
            c.addLast(i);
            generateCombinations(n, k, i + 1, c);
            c.removeLast();     // 清除当前i, 计算下一个start开始到满足c.size()==k的所有组合可能
        }

        return;


    }

    public List<List<Integer>> combine(int n, int k) {

        res.clear();
        if (n <= 0 || k <= 0 || k > n)
            return res;

        LinkedList<Integer> c = new LinkedList<Integer>();
        generateCombinations(n, k, 1, c);

        return res;

    }
}
