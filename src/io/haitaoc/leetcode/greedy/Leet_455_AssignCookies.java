package io.haitaoc.leetcode.greedy;

import java.util.Arrays;

public class Leet_455_AssignCookies {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int count = 0;
        for (int i = 0; count < g.length && i < s.length; ++i)
            count += g[count] <= s[i] ? 1 : 0;
        return count;
    }

    public static void main(String... args) {
        int[] g = {1,2,3};
        int[] s = {1,1};
        System.out.println(new Leet_455_AssignCookies().findContentChildren(g,s));
    }

}
