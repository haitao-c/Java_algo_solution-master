package io.haitaoc.leetcode.array;

public class Leet_3_LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        int[] freq=new int[256];
        int l = 0, r=-1;  // 滑动窗口为s[l...r]
        int res = 0;

        System.out.println(freq.length);

        while(l<s.length()){

            if(freq[s.charAt(r+1)]==0 && r+1<s.length()){
                r ++;
                freq[s.charAt(r)]++;
            }else{
                freq[s.charAt(l++)]--;
            }
            res = Math.max(res,r-l+1);
        }

        return res;
    }
}
