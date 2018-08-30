package io.haitaoc.leetcode.greedy;

public class Leet_392_IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        if(s.equals(""))
            return true;
        if(s.length()>t.length())
            return  false;
        int index = 0;
        for (int i = 0; i < t.length(); i++) {
            if(s.charAt(index)==t.charAt(i))
                index++;
            if(index==s.length())
                return true;
        }
        return false;
    }

    public static void main(String... args) {
        String s = "abc";
        String t = "ahbgdc";
        System.out.println(new Leet_392_IsSubsequence().isSubsequence(s, t));
    }

}
