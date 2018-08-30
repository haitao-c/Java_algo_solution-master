package io.haitaoc.leetcode.tree;

import io.haitaoc.util.TreeNode;

public class Leet_111_Minimum_Depth_of_Binary_Tree {

    // 函数的递归含义: 得出以root为根节点的最小深度, 则root为节点的最小深度=(左子树最小深度或右子树最小深度)+1
    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        int min = 0;
        if (root.left == null)              // 可能出现左子树直接为空, 右子树有值或相反的情况
            min = minDepth(root.right) + 1;
        if (root.right == null)
            min = minDepth(root.left) + 1;
        if (root.left != null && root.right != null)
            min = Math.min(minDepth(root.left), minDepth(root.right)) + 1;
        return min;
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

        System.out.println(new Leet_111_Minimum_Depth_of_Binary_Tree().minDepth(root));
    }
}
