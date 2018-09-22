package io.haitaoc.xiaozhao;

import java.util.Scanner;
import java.util.Stack;

public class TouTiao19_4_1 {

    public void run(){
        Scanner scan = new Scanner(System.in);
        String path = scan.nextLine();
        String res = simplifyPath(path);
        System.out.println(res);

    }

    public String simplifyPath(String path) {
        if (path == null || path.length() < 1) {
            return "";
        }
        Stack<String> stack = new Stack<>();
        String[] paths = path.split("/+");
        for (String s : paths) {
            if (s.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (!s.equals(".") && !s.equals("")) {
                stack.push(s);
            }
        }
        String res = "";
        while (!stack.isEmpty()) {
            res = "/" + stack.pop() + res;
        }
        if (res.length() == 0) {
            return "/";
        }
        return res;
    }



    public static void main(String[] args) {
        new TouTiao19_4_1().run();
    }
}
