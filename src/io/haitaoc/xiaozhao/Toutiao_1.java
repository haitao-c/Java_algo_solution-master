package io.haitaoc.xiaozhao;

import io.haitaoc.util.PrintArray;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Toutiao_1 {

    int[][] a;
    Map<Integer, Integer> map = null;


    public Toutiao_1(int[][] a) {
        this.a = a;
        int count = 0;
        for (int i = 0; i < a.length; i++)
            for (int j = 0; j < a[0].length; j++) {
                a[i][j] = a[i][j] == 0 ? 0 : ++count;

            }
        map = new HashMap();
    }

    public void union(int[][] a) {
        for (int i = 0; i < a.length; i++)
            for (int j = 0; j < a[0].length; j++) {
                if (a[i][j] != 0)
                    union(a, i, j);
            }

    }

    private void union(int[][] a, int i, int j) {
        if (isValid(a, i, j - 1)) {                 // 左
            if (a[i][j - 1] != 0)
                a[i][j] = a[i][j - 1];
        }
        if (isValid(a, i - 1, j + 1)) {           // 右上
            if (a[i - 1][j + 1] != 0)
                a[i][j] = a[i - 1][j + 1];
        }
        if (isValid(a, i - 1, j)) {                 // 上
            if (a[i - 1][j] != 0)
                a[i][j] = a[i - 1][j];
        }


        if (isValid(a, i - 1, j - 1)) {                    // 左上
            if (a[i - 1][j - 1] != 0) {
                a[i][j] = a[i - 1][j - 1];
                if (isValid(a, i - 1, j + 1)) {           // 右上
                    if (a[i - 1][j + 1] != 0)
                        a[i - 1][j + 1] = a[i][j];
                }
                if (isValid(a, i, j + 1)) {                 // 右
                    if (a[i][j + 1] != 0)
                        a[i][j + 1] = a[i][j];
                }
            }
        }
    }

    public Map scan(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                if (a[i][j] == 0)
                    continue;
                else {
                    int key = a[i][j];
                    if (map.containsKey(key))
                        map.put(key, map.get(key) + 1);
                    else
                        map.put(key, 1);
                }
            }
        }
        return map;
    }

    public int getTotal() {
        return map.size();
    }

    public int num() {
        Collection<Integer> c = map.values();
        Object[] nums = c.toArray();
        Arrays.sort(nums);
        return (int) nums[nums.length - 1];
    }


    private boolean isValid(int[][] a, int i, int j) {
        int rows = a.length - 1;
        int cols = a[0].length - 1;
        return i >= 0 && i <= rows && j >= 0 && j <= cols;
    }

    public static void main(String[] args) {
        int[][] input = new int[][]{
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 1, 0, 1, 0, 0, 0},
                {0, 1, 0, 0, 0, 0, 0, 1, 0, 1},
                {1, 0, 0, 0, 0, 0, 0, 0, 1, 1},
                {0, 0, 0, 1, 1, 1, 0, 0, 0, 1},
                {0, 0, 0, 0, 0, 0, 1, 0, 1, 1},
                {0, 1, 1, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 1, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 1, 0, 0, 0, 0},
                {0, 1, 0, 0, 0, 0, 0, 0, 0, 0}
        };
        Toutiao_1 t = new Toutiao_1(input);
        PrintArray.print(t.a);
        System.out.println();
        t.union(t.a);
        PrintArray.print(t.a);
        System.out.println();
        t.scan(t.a);
        System.out.println(t.getTotal() + "," + t.num());

    }
}


