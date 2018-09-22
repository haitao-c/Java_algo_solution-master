package io.haitaoc.xiaozhao;

import java.util.Scanner;

public class TouTiao19_4_2 {

    public void run(){
        Scanner scan = new Scanner(System.in);
        int N = Integer.parseInt(scan.nextLine());
        String[] words = new String[N];
        for (int i = 0; i < N; i++) {
            words[i] = scan.nextLine();
        }
        Trie root = createTrie(words);
        for (String s : words) {
            String prefix = prefix(root, s);
            System.out.println(prefix);
        }


    }


    public  class Trie {
        private char name;
        private int num = 1;
        private Trie[] next = new Trie[26];

        public Trie(char name) {
            this.name = name;
        }
    }


    public  Trie createTrie(String[] str) {

        Trie root = new Trie('-');
        Trie cur;

        for (String s : str) {
            cur = root;
            for (int i = 0; i < s.length(); i++) {

                int position = s.charAt(i)-'a';
                if(cur.next[position]==null) {
                    cur.next[position] = new Trie(s.charAt(i));
                }else {
                    cur.next[position].num++;
                }

                cur = cur.next[position];
            }
        }

        return root;
    }


    public  String prefix(Trie root,String str) {
        int len = 0;
        Trie cur;


        for (int i = 0; i < str.length(); i++) {

            cur = root.next[str.charAt(i)-'a'];
            if(cur==null) {
                break;
            }else if(cur.num==1) {

                len++;
                break;
            }else {
                len++;

                root = cur;
            }
        }
        return str.substring(0, len);
    }



    public static void main(String[] args) {
        new TouTiao19_4_2().run();
    }
}
