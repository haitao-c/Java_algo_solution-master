package io.haitaoc.leetcode.recursion;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Leet_417_PacificAtlanticWaterFlow {

    boolean[][] bP;
    boolean[][] bA;
    boolean[][] bCurrent;
    Queue<int[]> que;
    int nHeight;
    int nWidth;
    int[][] matrix;

    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> listResult = new ArrayList<>();
        if (matrix.length == 0) {
            return listResult;
        }
        /***
         * from left to right, it is Y=width, from top to bottom, it is x=Height
         */
        this.matrix = matrix;
        nHeight = matrix.length;
        nWidth = matrix[0].length;
        bP = new boolean[nHeight][nWidth];
        bA = new boolean[nHeight][nWidth];

        que = new LinkedList<int[]>();
        // add all pacific to queue
        bCurrent = bP;              // 将bP的引用传给bCurrent, 这个时候bCurrent的内容改变就是bP的内容改变
        addToQueue(0, 0);
        for (int i = 1; i < nWidth; i++) {
            addToQueue(0, i);
        }
        for (int i = 1; i < nHeight; i++) {
            addToQueue(i, 0);
        }
        while (que.size() > 0) {
            int[] nArrCurrent = que.poll();
            explore(nArrCurrent);
        }
        // add all atlantic to queue
        bCurrent = bA;
        addToQueue(nHeight - 1, nWidth - 1);
        for (int i = 0; i < nWidth - 1; i++) {
            addToQueue(nHeight - 1, i);
        }
        for (int i = 0; i < nHeight - 1; i++) {
            addToQueue(i, nWidth - 1);
        }
        while (que.size() > 0) {
            int[] nArrCurrent = que.poll();
            explore(nArrCurrent);
        }
        for (int i = 0; i < nHeight; i++) {
            for (int j = 0; j < nWidth; j++) {
                if (bP[i][j] && bA[i][j]) {
                    int[] nn = { i, j };
                    listResult.add(nn);
                }
            }
        }
        return listResult;
    }

    private void addToQueue(int x, int y) {
        int[] nn = { x, y };
        bCurrent[x][y] = true;
        que.add(nn);
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && y >= 0 && x < nHeight && y < nWidth;
    }

    private void explore(int[] n) {
        int x = n[0];
        int y = n[1];
        int value = matrix[x][y];
        if (inArea(x, y - 1)) {
            tagNewPoint(x, y - 1, value);
        }
        if (inArea(x, y + 1)) {
            tagNewPoint(x, y + 1, value);
        }
        if (inArea(x - 1, y)) {
            tagNewPoint(x - 1, y, value);
        }
        if (inArea(x + 1, y)) {
            tagNewPoint(x + 1, y, value);
        }
    }

    private void tagNewPoint(int x, int y, int value) {
        if (matrix[x][y] >= value && bCurrent[x][y] == false) {
            bCurrent[x][y] = true;
            int[] nn = { x, y };
            que.add(nn);
        }
    }


    public static void main(String[] args) {
        int[] a={1,2};
        int[] b;
        b = a;
        b[0]=3;
        System.out.println(a[0]);
    }
}
