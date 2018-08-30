package io.haitaoc.leetcode.queue;

//import io.haitaoc.util.Pair;

import io.haitaoc.util.TreeNode;
import javafx.util.Pair;

import java.util.*;


public class Leet_107_BinaryTreeLevelOrderTraversalII {
    // 参照util中的Pair, 存储两个元素
    class Pair {
        TreeNode node;
        int level;

        Pair(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
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
        Collections.reverse(res);
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
       /* List<List<Integer>> list = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        List<Integer> list2 = new ArrayList<>();
        list2.add(3);
        list2.add(4);
        list.add(list1);
        list.add(list2);
        // 将list中的元素反序
        Collections.reverse(list);
        System.out.println(list);*/
        System.out.println(new Leet_107_BinaryTreeLevelOrderTraversalII().levelOrderBottom(root));
    }
}
