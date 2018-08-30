package io.haitaoc.leetcode.dp;

import java.util.ArrayList;
import java.util.List;

public class Leet_139_WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        if(wordDict.size()==0||s.length()==0||s==null)
            return false;
        int n = wordDict.size();
        int[] dp = new int[n];
        return false;

    }
    public static void main(String... args) {
        String s = "leetcode";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("leet");
        wordDict.add("code");
        System.out.println(Integer.MIN_VALUE);
        System.out.println(new Leet_139_WordBreak().wordBreak(s,wordDict));
    }

}
