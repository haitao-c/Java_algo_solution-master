package io.haitaoc.leetcode.tree;

import io.haitaoc.util.TreeNode;

public class Leet_404_SumofLeftLeaves {

    public int sumOfLeftLeaves(TreeNode root) {

        int res = 0;

        if (root == null)
            return res;

        if (root.left != null && root.left.left == null && root.left.right == null) {
            res += root.left.val;
        }
        res += sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
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

        System.out.println(new Leet_404_SumofLeftLeaves().sumOfLeftLeaves(root));
    }
}
