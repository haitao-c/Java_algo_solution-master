package io.haitaoc.leetcode.tree;

import io.haitaoc.util.TreeNode;

public class Leet_104_MaximumDepth {
    /**
     * 函数定义为  计算以root为根节点的二叉树的最大深度
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if(root==null)
            return 0;

        int leftMaxDepth = maxDepth(root.left);
        int rightMaxDepth = maxDepth(root.right);
        return Math.max(leftMaxDepth,rightMaxDepth)+1;

    }
}
