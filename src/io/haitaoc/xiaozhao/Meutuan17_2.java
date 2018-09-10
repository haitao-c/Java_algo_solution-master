package io.haitaoc.xiaozhao;

import java.util.Scanner;

public class Meutuan17_2 {

    int[] coins = {1, 5, 10, 20, 50, 100};

    public void run() {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        long res = allCombines(N);
        System.out.println(res);
    }

    private long allCombines(int N) {
        int m = coins.length;
        long[][] dp = new long[m][N + 1];
        for (int i = 0; i < N + 1; i++) {
            dp[0][i] = 1;
        }

        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < N + 1; j++) {
                int k = j / coins[i];
                for (int l = 0; l <= k; l++) {
                    dp[i][j] = dp[i][j] + dp[i - 1][j - l * coins[i]];
                }
            }
        }
        return dp[m - 1][N];
    }


    public static void main(String[] args) {
        new Meutuan17_2().run();
    }
}
