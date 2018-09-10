package io.haitaoc.xiaozhao;

import java.util.Scanner;

public class Toutiao19_2 {
    int M;
    boolean[][] marked;
    int res = 0;
    int[][] d = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public void run() {
        Scanner scan = new Scanner(System.in);
        M = Integer.parseInt(scan.nextLine());
        if(M<=0){
            System.out.println(0);
            return;
        }

        int[][] a = new int[M][M];
        for (int i = 0; i < M; i++) {
            String[] in = scan.nextLine().split(" ");
            for (int j = 0; j < in.length; j++) {
                a[i][j] = Integer.parseInt(in[j]);
            }
        }
        marked = new boolean[M][M];

        //PrintArray.print(a);
        System.out.println(num(a));

    }

    private int num(int[][] a) {
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                if (a[i][j] == 1 && !marked[i][j]) {
                    res++;
                    dfs(a, i, j);
                }
            }
        }
        return res;
    }

    private void dfs(int[][] a, int x, int y) {
        marked[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int newx = x + d[i][0];
            int newy = y + d[i][1];
            if (inArea(newx, newy) && !marked[newx][newy] && a[newx][newy] == 1) {
                dfs(a, newx, newy);
            }
        }
        return;

    }

    private boolean inArea(int x, int y) {
        return x >= 0 && y >= 0 && x < M && y < M;
    }


    public static void main(String[] args) {
        new Toutiao19_2().run();

    }
}
