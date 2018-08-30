package io.haitaoc.leetcode.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Leet_71_SimplifyPath {
    public String simplifyPath(String path) {
        String[] l = path.split("/");
        Stack<String> stack = new Stack<>();
        for (String s:l){
            if(s.equals("")||s.equals("."))
                continue;
            if(s.equals("..")){
                if(!stack.isEmpty()){
                    stack.pop();
                }
            }
            else {
                stack.push(s);
            }
        }

        List<String> list = new ArrayList<>(stack);
        return "/"+String.join("/",list);
    }

    public static void main(String[] args){
        String path = "/abc/...";
        System.out.println(new Leet_71_SimplifyPath().simplifyPath(path));
    }
}
