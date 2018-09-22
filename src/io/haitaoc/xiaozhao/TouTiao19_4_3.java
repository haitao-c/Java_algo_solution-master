package io.haitaoc.xiaozhao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TouTiao19_4_3 {
    private int[] dy = {-1, 1, 0, 0};
    private int[] dx = {0, 0, -1, 1};
    List<String> res ;
    public void run(){
        Scanner scan = new Scanner(System.in);
        String[] f = scan.nextLine().split(" ");
        int M= Integer.parseInt(f[0]);
        int N = Integer.parseInt(f[1]);
        int K = Integer.parseInt(f[2]);
        res = new ArrayList<>();
        String[] words =new String[K];
        String[] inputWords = scan.nextLine().split(" ");
        if(inputWords.length!=K)
            return ;
        else
            words = inputWords;
        char[][] dic = new char[N][M];
        for (int i = 0; i <N ; i++) {
            String[] in = scan.nextLine().split(" ");
            for (int j = 0; j <M ; j++) {
                dic[i][j] = in[j].charAt(0);
            }
        }
        res = findWords(dic,words);
       for(String word:words)
           if(res.contains(word))
               System.out.println(word);

    }

    private void find(char[][] board, boolean[][] visit, int y, int x, Trie node, List<String> results) {
        if (y < 0 || y >= board.length || x < 0 || x >= board[y].length) return;
        if (visit[y][x]) return;
        visit[y][x] = true;
        Trie next = node.nexts[board[y][x]-'a'];
        if (next != null) {
            if (next.word != null) {
                results.add(next.word);
                next.word = null;
            }
            for(int i=0; i<4; i++) {
                int ny = y+dy[i];
                int nx = x+dx[i];
                find(board, visit, ny, nx, next, results);
            }
        }
        visit[y][x] = false;
    }
    public List<String> findWords(char[][] board, String[] words) {
        Trie root = new Trie();
        for(String word: words) {
            Trie node = root;
            char[] wa = word.toCharArray();
            for(char c: wa) node = node.append(c);
            node.word = word;
        }
        boolean[][] visit = new boolean[board.length][board[0].length];
        List<String> results = new ArrayList<>();
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[i].length; j++) {
                find(board, visit, i, j, root, results);
            }
        }
        return new ArrayList<>(results);
    }

class Trie {
    String word;
    Trie[] nexts = new Trie[26];

    Trie append(char ch) {
        if (nexts[ch - 'a'] == null) nexts[ch - 'a'] = new Trie();
        return nexts[ch - 'a'];
    }

}


    public static void main(String[] args) {
        new TouTiao19_4_3().run();
    }
}
