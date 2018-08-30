package io.haitaoc.leetcode.array;

import java.util.ArrayList;
import java.util.List;

public class Leet_438_FindAllAnagrams {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int[] freq_s = new int[26];
        int[] freq_p = new int[26];
        for (char c : p.toCharArray())
            freq_p[c - 'a'] += 1;    // 记录p字符串中每个字符出现的次数
        int l = 0, r = -1;           // 滑动窗口大小 [l..r]
        while (r + 1 < s.length()) {
            r++;
            freq_s[s.charAt(r) - 'a']++;
            if (r - l + 1 > p.length())
                freq_s[s.charAt(l++) - 'a']--;
            if (r - l + 1 == p.length() && isMatch(freq_s, freq_p))
                res.add(l);
        }
        return res;

    }

    private boolean isMatch(int[] freq_s, int[] freq_p) {
        for (int i = 0; i < 26; i++)
            if (freq_s[i] != freq_p[i])
                return false;
        return true;
    }

    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        System.out.println(new Leet_438_FindAllAnagrams().findAnagrams(s, p));
    }
}
