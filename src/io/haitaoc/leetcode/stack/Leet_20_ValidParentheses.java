package io.haitaoc.leetcode.stack;

import java.util.Stack;

public class Leet_20_ValidParentheses {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) return true;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
                continue;
            }
            if (stack.isEmpty()) return false;
            char pk = stack.peek();
            if (c == '}' && pk != '{') return false;
            if (c == ']' && pk != '[') return false;
            if (c == ')' && pk != '(') return false;
            stack.pop();
        }
        return stack.isEmpty();
    }

    public static void main(String[] args){
        String s = "";
        System.out.println(new Leet_20_ValidParentheses().isValid(s));
    }
}
