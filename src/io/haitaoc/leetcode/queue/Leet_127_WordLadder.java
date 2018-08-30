package io.haitaoc.leetcode.queue;

import java.util.*;

public class Leet_127_WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (wordList == null || wordList.size() == 0 || !wordList.contains(endWord))
            return 0;
        // 因为wordList中没有重复单词, 可以将其转换为set同时再访问过set中某个单词后将其从set中删除, 起到visited的标志作用
        Set<String> wordSet = new HashSet<>(wordList);
        Queue<String> q = new LinkedList<>();
        int res = 1;
        q.offer(beginWord);
        wordSet.remove(beginWord);
        while (!q.isEmpty()) {
            int N = q.size();
            res++;
            // 遍历完当前层的所有队列中元素
            for (int i = 0; i < N; i++) {
                String word = q.poll();
                char[] wordArray = word.toCharArray();
                for (int j = 0; j < word.length(); j++) {
                    char temp = wordArray[j];       // 先把第j个位置上的char拿出来, 因为下面的循环会改变那个位置的值,变完后需要再重设回来
                    for (char c = 'a'; c <='z' ; c++) {
                        // replace函数把字符串中所有匹配的字符都替换了,如leet.replace('e','a'),变为'laat'
                        wordArray[j] = c;
                        String s = new String(wordArray);
                        if (wordSet.contains(s)){
                            if(s.equals(endWord))
                                return res;
                            else{
                                q.offer(s);
                                wordSet.remove(s);
                            }
                        }
                    }
                    wordArray[j] = temp;
                }
            }
        }
        // 注意返回值得设置, 如果能找到结尾的值, 循环中就已经返回正确的长度值res, 执行到此处说明没有找到, 返回0
        return 0;
    }


    public static void main(String[] args) {
        String beginWord = "leet";
        String endWord = "code";
        List<String> list = new ArrayList<>(Arrays.asList("lest","leet","lose","code","lode","robe","lost"));
        System.out.println(new Leet_127_WordLadder().ladderLength(beginWord, endWord, list));
    }
}
