package io.haitaoc.leetcode.tree;

import io.haitaoc.util.TreeNode;

public class Leet_101_SymmetricTree {
    // 考虑两个节点的左右子树
    public boolean isSymmetric(TreeNode root) {
        if(root==null)
            return true;
        return isMirror(root,root);
    }

    private boolean isMirror(TreeNode root1, TreeNode root2) {
        if(root1==null&&root2==null)
            return true;
        if(root1==null||root2==null)
            return false;
        if(root1.val==root2.val&&isMirror(root1.left,root2.right)&&isMirror(root1.right,root2.left))
            return true;
        return false;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(3);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;
        System.out.println(new Leet_101_SymmetricTree().isSymmetric(root));
    }
}
