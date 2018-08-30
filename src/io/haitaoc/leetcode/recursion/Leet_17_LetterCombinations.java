package io.haitaoc.leetcode.recursion;

import java.util.ArrayList;
import java.util.List;

public class Leet_17_LetterCombinations {
    String[] letterMap = {
            " ",    // 0
            "",     // 1
            "abc",  // 2
            "def",  // 3
            "ghi",  // 4
            "jkl",  // 5
            "mno",  // 6
            "pqrs", // 7
            "tuv",  // 8
            "wxyz"  // 9
    };

    List<String> res = new ArrayList<>();

    // s中保存了此时从digits[0...index-1]翻译得到的一个字母字符串
    // 寻找和digits[index]匹配的字母, 获得digits[0...index]翻译得到的解

    private void findCombination(String digits, int index, String s) {
        System.out.println(index+" : "+s);

        if(index == digits.length()){
             // 保存s
            res.add(s);
            System.out.println("get "+s+" , return");
            return;
        }

        char c = digits.charAt(index);
        assert (c >= '0' && c <= '9' && c != '1');
        String letters = letterMap[c - '0'];  // 找到当前数字对应的字母有哪些
        for (int i = 0; i < letters.length(); i++) {
            System.out.println("digits["+index+"] = "+c+", use "+letters.charAt(i));
            findCombination(digits, index + 1, s + letters.charAt(i));
        }
        System.out.println("digits["+index+"] = "+c+" complete, return");

    }

    public List<String> letterCombinations(String digits) {
        res.clear();

        if(digits.equals(""))
            return res;

        findCombination(digits,0,"");

        return res;
    }

    public static void main(String[] args){
        List<String> res = new Leet_17_LetterCombinations().letterCombinations("234");
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }
    }

}
