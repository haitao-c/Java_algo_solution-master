package io.haitaoc.leetcode.tree;

import io.haitaoc.util.TreeNode;

public class Leet_222_CountCompleteTreeNodes {

    /**
     The height of a tree can be found by just going left. Let a single node tree have height 0. Find the height h of the whole tree. If the whole tree is empty, i.e., has height -1, there are 0 nodes.

     Otherwise check whether the height of the right subtree is just one less than that of the whole tree, meaning left and right subtree have the same height.

     If yes, then the last node on the last tree row is in the right subtree and the left subtree is a full tree of height h-1. So we take the 2^h-1 nodes of the left subtree plus the 1 root node plus recursively the number of nodes in the right subtree.
     If no, then the last node on the last tree row is in the left subtree and the right subtree is a full tree of height h-2. So we take the 2^(h-1)-1 nodes of the right subtree plus the 1 root node plus recursively the number of nodes in the left subtree.
     */
    int height(TreeNode root) {     // 根节点在第0层
        return root == null ? -1 : 1 + height(root.left);
    }
    public int countNodes(TreeNode root) {
        int h = height(root);
        return h < 0 ? 0 :
                height(root.right) == h-1 ? (1 << h) + countNodes(root.right)       // 最后一个节点在右子树, 左子树满节点
                        : (1 << h-1) + countNodes(root.left);   // 右子树满节点, 且比左子树高度少1, 最后一个节点在左子树
    }

    public int countNodes4(TreeNode root){
        if(root == null)
            return 0;
        int left = countNodes4(root.left);
        int right = countNodes4(root.right);
        return left+right+1;
    }

    // 递归求出深度后计算节点数
    /* 递归求出最左边节点结束位置的深度, 求最大深度时的左节点一定在左子树中*/
    public int countNodes3(TreeNode root) {
        if(root == null)
            return 0;

        int leftLeft = leftHeight(root.left);
        int leftRight = rightHeight(root.left);
        if(leftLeft == leftRight)   // 如果左子树的左右深度相同, 则左子树的所有节点数为2^leftLeft-1, 然后通过递归求出右子树所有节点树再加上根节点1即可
            return 1 + ((1<<leftLeft) - 1) + countNodes3(root.right);

        assert(leftLeft == leftRight + 1);  //说明右子树是满的, 最后一个节点在左子树
        return 1 + ((1<<leftRight) - 1) + countNodes3(root.left);
    }

    private int leftHeight(TreeNode root) {
        if (root == null)
            return 0;
        return 1 + leftHeight(root.left);
    }

    private int rightHeight(TreeNode root) {
        if (root == null)
            return 0;
        return 1 + rightHeight(root.right);
    }


    // 递归逐个统计节点的解法超时
    public int countNodes2(TreeNode root) {
        int cnt = 0;
        if (root == null)
            return cnt;
        else {
            cnt = 1;
            cnt = countNodes(root, cnt);
        }


        return cnt;
    }

    private int countNodes(TreeNode root, int cnt) {
        if (root == null)
            return 0;
        if (root.left != null)
            cnt = countNodes(root.left, cnt) + 1;
        if (root.right != null)
            cnt = countNodes(root.right, cnt) + 1;
        return cnt;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(6);

        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;

        System.out.println(new Leet_222_CountCompleteTreeNodes().countNodes(root));


    }
}
