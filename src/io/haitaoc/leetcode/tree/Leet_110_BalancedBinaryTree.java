package io.haitaoc.leetcode.tree;

import io.haitaoc.util.TreeNode;

public class Leet_110_BalancedBinaryTree {

    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        int left = height(root.left);       // 求出左子树高度
        int right = height(root.right);     // 求出右子树高度
        // 判断左右子树高度差以及左右子树各自是否平衡
        return Math.abs(left - right) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    public int height(TreeNode node){       // 求出以node为节点的树的高度
        int h = 0;
        if(node == null) return h;
        return 1 + Math.max(height(node.left), height(node.right));
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

        System.out.println(new Leet_110_BalancedBinaryTree().isBalanced(root));
    }
}
