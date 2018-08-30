package io.haitaoc.leetcode.stack;

import java.util.Stack;

public class Leet_150_EvaluateReversePolishNotation {

    public int evalRPN(String[] tokens) {
        if (tokens.length == 0 )
            return 0;
        Stack<String> stack = new Stack<>();
        for (String s : tokens) {
            if(!isOperation(s))
                stack.push(s);
            else{
                int m = Integer.parseInt(stack.pop());
                int n = Integer.parseInt(stack.pop());
                if(s.equals("+"))
                    stack.push(String.valueOf(m+n));
                else if(s.equals("-"))
                    stack.push(String.valueOf(n-m));
                else if(s.equals("*"))
                    stack.push(String.valueOf(m*n));
                else if(s.equals("/"))
                    stack.push(String.valueOf(n/m));
            }
        }
        return Integer.parseInt(stack.pop());

    }
    private boolean isOperation(String s){
        if(s.equals("+")||s.equals("-")||s.equals("*")||s.equals("/"))
            return true;
        return false;
    }

    public static void main(String[] args) {
        String[] tokens = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        System.out.println(new Leet_150_EvaluateReversePolishNotation().evalRPN(tokens));

    }
}
