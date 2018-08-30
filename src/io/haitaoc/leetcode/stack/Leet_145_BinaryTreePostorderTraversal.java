package io.haitaoc.leetcode.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Leet_145_BinaryTreePostorderTraversal {
    class Command {
        String info;
        TreeNode node;

        Command(String info, TreeNode node) {
            this.info = info;
            this.node = node;
        }
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root==null)
            return res;
        Stack<Command> stack  = new Stack<>();
        Command cmd = new Command("go",root);
        stack.push(cmd);
        while(!stack.isEmpty()){
            Command command = stack.pop();
            if(command.info.equals("print"))
                res.add(command.node.val);
            else{
                assert (command.info.equals("go"));
                // 把当前节点压入栈中, 等左子树和右子树遍历完成后输出值
                stack.push(new Command("print",command.node));
                if(command.node.right!=null)
                    stack.push(new Command("go",command.node.right));
                if(command.node.left!=null)
                    stack.push(new Command("go",command.node.left));
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
        System.out.println(new Leet_145_BinaryTreePostorderTraversal().postorderTraversal(root));
    }

}
