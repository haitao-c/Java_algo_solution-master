package io.haitaoc.leetcode.dp;

import java.util.Arrays;

// F(n,C)考虑将n个物品放进容量为C的背包，使得价值最大
// F(i,c) = F(i-1,c)            出现的原因, i-1个物品已经使背包容量到c
//        = v(i)+F(i-1,c-w(i))  放进第i个物品
// F(i,c) = max(F(i-1,c),v(i)+F(i-1,c-w(i)))
public class Knapsack01 {
    public int Op2DpKnapsack01(int[] w, int[] v, int C) {
        assert w.length == v.length;
        int n = w.length;
        if (n == 0)
            return 0;
        int[] memo = new int[C + 1];

        for (int i = 0; i <= C; i++) {
            memo[i] = (i >= w[0] ? v[0] : 0);
        }
        for (int i = 1; i < n; i++) {
            for (int j = C; j >= w[i]; j--) {
                memo[j] = Math.max(memo[j], v[i] + memo[j - w[i]]);
            }
        }
        return memo[C];
    }

    public int OpDpKnapsack01(int[] w, int[] v, int C) {
        assert w.length == v.length;
        int n = w.length;
        if (n == 0)
            return 0;
        int[][] memo = new int[2][C + 1];
        for (int i = 0; i <= C; i++) {
            memo[0][i] = (i >= w[0] ? v[0] : 0);
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= C; j++) {
                memo[i % 2][j] = memo[(i - 1) % 2][j];
                if (j >= w[i])
                    memo[i % 2][j] = Math.max(memo[i % 2][j], v[i] + memo[(i - 1) % 2][j - w[i]]);
            }
        }
        return memo[(n - 1) % 2][C];
    }

    public int dpKnapsack01(int[] w, int[] v, int C) {
        assert w.length == v.length;
        int n = w.length;
        if (n == 0)
            return 0;
        int[][] memo = new int[n][C + 1];
        for (int i = 0; i <= C; i++) {
            memo[0][i] = (i >= w[0] ? v[0] : 0);
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= C; j++) {
                memo[i][j] = memo[i - 1][j];
                if (j >= w[i])
                    memo[i][j] = Math.max(memo[i][j], v[i] + memo[i - 1][j - w[i]]);
            }
        }
        return memo[n - 1][C];
    }

    public int knapsack01(int[] w, int[] v, int C) {
        int n = w.length;
        int[][] memo = new int[n][C + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(memo[i], -1);
        }

        // 1.return bestValue(w,v,n-1,C);
        return memoBestValue(w, v, n - 1, C, memo);
    }

    // 用[0...index]的物品 填充容积为c的背包的最大价值
    private int bestValue(int[] w, int[] v, int index, int c) {
        if (index < 0 || c <= 0)
            return 0;

        int res = bestValue(w, v, index - 1, c);
        if (c >= w[index])
            res = Math.max(res, v[index] + bestValue(w, v, index - 1, c - w[index]));
        return res;
    }

    // 用[0...index]的物品 填充容积为c的背包的最大价值
    private int memoBestValue(int[] w, int[] v, int index, int c, int[][] memo) {
        if (index < 0 || c <= 0)
            return 0;

        if (memo[index][c] != -1)
            return memo[index][c];

        int res = bestValue(w, v, index - 1, c);
        if (c >= w[index])
            res = Math.max(res, v[index] + bestValue(w, v, index - 1, c - w[index]));
        memo[index][c] = res;
        return res;
    }

    public static void main(String... args) {
        int[] w = {1, 2, 3};
        int[] v = {6, 10, 12};
        System.out.println(new Knapsack01().dpKnapsack01(w, v, 5));
    }

}
