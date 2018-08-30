package io.haitaoc.leetcode.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

/*
// 递归遍历
   public void preorderTraversal(TreeNode root) {
           if(root==null)
                return;
           System.out.println(root.val);
           preorderTraversal(root.left);
           preorderTraversal(root.right);
    }
* */
public class Leet_144_BinaryTreePreorderTraversal {
    class Command {
        String s;
        TreeNode node;

        Command(String s, TreeNode node) {
            this.s = s;
            this.node = node;
        }
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null)
            return res;
        Stack<Command> stack = new Stack<>();
        stack.push(new Command("go", root));
        while (!stack.isEmpty()) {
            Command command = stack.pop();
            if (command.s.equals("print"))
                res.add(command.node.val);
            else {
                assert (command.s.equals("go"));
                if (command.node.right != null)
                    stack.push(new Command("go", command.node.right));
                if (command.node.left != null)
                    stack.push(new Command("go", command.node.left));
                stack.push(new Command("print", command.node));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        root.right = node1;
        node1.left = node2;
        System.out.println(new Leet_144_BinaryTreePreorderTraversal().preorderTraversal(root));
    }
}
