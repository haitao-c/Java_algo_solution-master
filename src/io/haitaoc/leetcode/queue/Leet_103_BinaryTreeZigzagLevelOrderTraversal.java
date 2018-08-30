package io.haitaoc.leetcode.queue;

import io.haitaoc.util.TreeNode;

import java.util.*;

public class Leet_103_BinaryTreeZigzagLevelOrderTraversal {
    // 参照util中的Pair, 存储两个元素
    class Pair{
        TreeNode node;
        int level;
        Pair(TreeNode node, int level){
            this.node = node;
            this.level = level;
        }
    }

    /**
     * 傻逼, 先不管最后输出顺序, 层序遍历完放到list里,再按照输出形式对list操作即可
     * @param root
     * @return
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
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
            } else {
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
        for (int i = 0; i < res.size(); i++) {
            if(i%2!=0)
                Collections.reverse(res.get(i));
        }

        return res;
    }



    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(20);
        TreeNode node3 = new TreeNode(15);
        TreeNode node4 = new TreeNode(7);
        root.left = node1;
        root.right = node2;
        node2.left = node3;
        node2.right = node4;
        System.out.println(new Leet_103_BinaryTreeZigzagLevelOrderTraversal().zigzagLevelOrder(root));
    }
}