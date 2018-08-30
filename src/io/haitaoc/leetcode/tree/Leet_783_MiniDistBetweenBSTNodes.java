package io.haitaoc.leetcode.tree;

import io.haitaoc.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Leet_783_MiniDistBetweenBSTNodes {

    /**
     * 4
     * /   \
     * 2    6
     * / \
     * 1   3
     */

    public int minDiffInBST(TreeNode root) {
        List<Integer> res=new ArrayList<Integer>();
        inorder(res,root);
        int min=Integer.MAX_VALUE;
        for(int i=1;i<res.size();i++){
            min=Math.min(min,res.get(i)-res.get(i-1));
        }
        return min;
    }
    private void inorder(List<Integer> res, TreeNode root){
        if(root==null)
            return;
        inorder(res,root.left);
        res.add(root.val);
        inorder(res,root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(6);
        TreeNode node3 = new TreeNode(1);
        TreeNode node4 = new TreeNode(3);


        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;

        System.out.println(new Leet_783_MiniDistBetweenBSTNodes().minDiffInBST(root));
    }


}
