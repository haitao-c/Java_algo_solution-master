package io.haitaoc.leetcode;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Test {

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        if (root.left == null && root.right == null && root.val == sum) return true;
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }

    public static void main(String...args){
        TreeNode root = new TreeNode(5);
        TreeNode node1=new TreeNode(4);
        TreeNode node2=new TreeNode(8);
        root.left = node1;
        root.right = node2;
        TreeNode node1Left=new TreeNode(11);
        node1.left=node1Left;
        TreeNode node1LeftLeft = new TreeNode(7);
        TreeNode node1LeftRight = new TreeNode(2);
        node1Left.left=node1LeftLeft;
        node1Left.right=node1LeftRight;
        TreeNode node2Left = new TreeNode(13);
        TreeNode node2Right = new TreeNode(4);
        node2.left=node2Left;
        node2.right=node2Right;
        TreeNode node2RightRight=new TreeNode(1);
        node2Right.right=node2RightRight;
        System.out.println(new Test().hasPathSum(root,22));




    }
}
