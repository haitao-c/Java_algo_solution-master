package io.haitaoc.xiaozhao;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Toutiao19_1 {

    public void run() {
        Scanner scan = new Scanner(System.in);
        String in = scan.nextLine();
        System.out.println(lenth(in));

    }

    public int longestSubstring(String A, int n) {

        //charPosition统计A中每种字符之前出现的位置
        Map<Character, Integer> charPosition = new HashMap<Character, Integer>();

        //preArr代表以s[i-1]结尾的情况下，最长无重复子串的长度
        int[] preArr = new int[A.length()];


        char[] str2charArr = A.toCharArray();

        //从头到尾遍历str2charArr，统计出以每个字符为当前位置的向前最长无重复子串的长度

        for(int i=0; i<A.length(); i++){

            Integer lastPosOfChar = charPosition.get(str2charArr[i]);

            if(lastPosOfChar == null){//说明当前字符第一次出现

                //更新最长无重复子串的长度
                preArr[i] = i == 0 ? 1 : preArr[i-1] + 1;

                //记录当前字符出现的位置
                charPosition.put(str2charArr[i], i);

            }

            else{//当前字符不是第一次出现(既然不是第一次出现，那也不是在第一个位置),也就是之前出现过该字符

                //获取前一个字符最长无重复子串的长度
                int aPos = lastPosOfChar + 1;

                int unRepeatLen = preArr[i-1];

                int bPos = i - unRepeatLen;

                if(aPos >= bPos){

                    //当前位置的最长无重复子串长度
                    preArr[i] = i - aPos + 1;

                }

                else{

                    //当前位置的最长无重复子串长度
                    preArr[i] = i - bPos + 1;

                }

                //跟新当前字符出现的位置
                charPosition.put(str2charArr[i], i);

            }

        }

        //遍历preArr,最大值即为所求

        int max = preArr[0];

        for(int i: preArr) if(i > max) max = i;


        return max;

    }

    private int lenth(String in){
        int n = in.length();
        return longestSubstring(in,n);
    }


    public static void main(String[] args) {
        new Toutiao19_1().run();

    }
}
