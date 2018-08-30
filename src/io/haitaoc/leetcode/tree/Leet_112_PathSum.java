package io.haitaoc.leetcode.tree;

import io.haitaoc.util.TreeNode;

public class Leet_112_PathSum {

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null)           // 如果根节点为空, 返回false
            return false;

        if (root.val == sum && root.left == null && root.right == null) // 到达叶子节点
            return true;

        return hasPathSum(root.left,sum-root.val)||hasPathSum(root.right,sum-root.val);
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(8);
        TreeNode node3 = new TreeNode(11);
        TreeNode node4 = new TreeNode(13);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(7);
        TreeNode node7 = new TreeNode(2);
        TreeNode node8 = new TreeNode(1);

        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node2.left  = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        node5.right = node8;

        System.out.println(new Leet_112_PathSum().hasPathSum(root,22));
    }
}
