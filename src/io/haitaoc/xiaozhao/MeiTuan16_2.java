package io.haitaoc.xiaozhao;

import io.haitaoc.util.PrintArray;

public class MeiTuan16_2 {
    int m;
    int n;
    // 向上移动, x位置-1, y位置不动
    // 向右移动, x位置不动, y位置+1
    int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public int[][] flipChess(int[][] A, int[][] f) {
        m = A.length;
        n = A[0].length;
        int[][] T = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                T[i][j] = A[i - 1][j - 1];
            }
        }
        int fR = f.length;
        for (int i = 0; i < fR; i++) {
            int row = f[i][0];
            int col = f[i][1];
            for (int j = 0; j < directions.length; j++) {
                int x = row + directions[j][0];
                int y = col + directions[j][1];
                if (inArea(x, y)) {
                    T[x][y] = T[x][y] == 0 ? 1 : 0;
                }
            }
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                A[i-1][j-1] = T[i][j];
            }
        }
        return A;

    }

    private boolean inArea(int x, int y) {
        return x >= 1 && y >= 1 && x <= m && y <= n;
    }

    public static void main(String[] args) {
            int[][] A={{0,0,1,1},{1,0,1,0},{0,1,1,0},{0,0,1,0}};
            int[][] f={{2,2},{3,3},{4,4}};
        PrintArray.print(A);
        System.out.println();
        new MeiTuan16_2().flipChess(A,f);
        PrintArray.print(A);
    }
}
