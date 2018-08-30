package io.haitaoc.leetcode.queue;

import io.haitaoc.util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Leet_199_BinaryTreeRightSideView {

    // 参照util中的Pair, 存储两个元素
    class Pair {
        TreeNode node;
        int level;

        Pair(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }

    /**
     * 按层序遍历, 将每一层的结果保存的list中,再统一放进存储每层list的List中
     * 取出每层结果的最后一个元素
     * @param root
     * @return
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<List<Integer>> res = levelOrder(root);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < res.size(); i++) {
            List<Integer> tmp = res.get(i);
            list.add(tmp.get(tmp.size()-1));
        }
        return list;
        
    }

    private List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        Queue<Pair> q = new LinkedList<>();
        Pair Pair = new Pair(root, 0);
        q.offer(Pair);
        while (!q.isEmpty()) {
            Pair e = q.poll();
            if (e.level == res.size()) {        // 所在层数与res的大小相同
                List<Integer> list = new ArrayList<>();
                list.add(e.node.val);
                res.add(list);
            } else {                            // 否则说明res中已经有该层的list,直接添加就可以
                res.get(e.level).add(e.node.val);
            }
            if (e.node.left != null) {
                Pair pair1 = new Pair(e.node.left, e.level + 1);
                q.offer(pair1);
            }
            if (e.node.right != null) {
                Pair pair2 = new Pair(e.node.right, e.level + 1);
                q.offer(pair2);
            }
        }
        return res;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(5);
        TreeNode node4 = new TreeNode(4);
        root.left = node1;
        root.right = node2;
        node1.right = node3;
        node2.right = node4;
        System.out.println(new Leet_199_BinaryTreeRightSideView().rightSideView(root));
    }
}
