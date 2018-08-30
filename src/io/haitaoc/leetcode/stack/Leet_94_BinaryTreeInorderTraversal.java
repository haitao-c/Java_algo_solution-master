package io.haitaoc.leetcode.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class Leet_94_BinaryTreeInorderTraversal {


    class Command {
        String info;
        TreeNode node;

        Command(String info, TreeNode node) {
            this.info = info;
            this.node = node;
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<Command> stack = new Stack<>();
        if (root == null)
            return res;
        // 先把根节点放进栈中
        Command command = new Command("go", root);
        stack.push(command);
        while (!stack.isEmpty()) {
            // 按照每个节点的逻辑处理
            Command cmd = stack.pop();
            if (cmd.info.equals("print"))
                res.add(cmd.node.val);
            else {
                assert (command.info.equals("go"));
                if (cmd.node.right != null)
                    stack.push(new Command("go", cmd.node.right));
                stack.push(new Command("print",cmd.node));
                if (cmd.node.left != null)
                    stack.push(new Command("go", cmd.node.left));
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
        System.out.println(new Leet_94_BinaryTreeInorderTraversal().inorderTraversal(root));
    }
}
