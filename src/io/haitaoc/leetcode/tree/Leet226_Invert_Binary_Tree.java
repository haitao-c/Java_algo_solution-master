package io.haitaoc.leetcode.tree;

import io.haitaoc.util.TreeNode;


public class Leet226_Invert_Binary_Tree {
    /**
     * 清楚函数的定义是翻转以root为根节点的二叉树，即左右子树翻转
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        if(root==null)
            return null;

        invertTree(root.left);              // 翻转以left为根的二叉树
        invertTree(root.right);             // 翻转以right为根的二叉树
        swap(root);         // 交换左右子树
        return root;
    }

    private void swap(TreeNode root) {
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }

    private void swap(TreeNode node1,TreeNode node2){
        TreeNode temp = node1;
        node1 = node2;
        node2 = temp;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        new Leet226_Invert_Binary_Tree().swap(node1,node2);
        System.out.println(node1.val);
    }
}
