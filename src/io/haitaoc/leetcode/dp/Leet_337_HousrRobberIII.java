package io.haitaoc.leetcode.dp;
class TreeNode {
     int val;
      TreeNode left;
      TreeNode right;
     TreeNode(int x) { val = x; }
  }
public class Leet_337_HousrRobberIII {
    public int rob(TreeNode root) {
        return 0;

    }

    public static void main(String... args) {
       TreeNode root = new TreeNode(3);
       TreeNode node1 = new TreeNode(2);
       TreeNode node2 = new TreeNode(3);
       TreeNode node3 = new TreeNode(3);
       TreeNode node4 = new TreeNode(1);
       root.left = node1;
       root.right = node2;
       node1.right = node3;
       node2.right = node4;
       System.out.println(new Leet_337_HousrRobberIII().rob(root));
    }
}
