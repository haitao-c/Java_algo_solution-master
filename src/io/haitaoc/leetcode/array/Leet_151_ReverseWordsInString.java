package io.haitaoc.leetcode.array;

public class Leet_151_ReverseWordsInString {

    public String reverseWords(String s) {
            String[] splited = s.split(" +");
            StringBuilder sb = new StringBuilder();
        for (int i = splited.length-1; i >=0 ; i--) {
            sb.append(splited[i]+" ");
        }
        return sb.toString().trim();
    }

    public static void main(String[] args) {
        System.out.println(new Leet_151_ReverseWordsInString().reverseWords("   a   b"));
    }
}
