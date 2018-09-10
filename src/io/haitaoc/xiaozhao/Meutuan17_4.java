package io.haitaoc.xiaozhao;

import io.haitaoc.util.PrintArray;

import java.util.Arrays;
import java.util.Scanner;

public class Meutuan17_4 {

    public void run() {
        Scanner scan = new Scanner(System.in);
        String a = scan.nextLine();
        String b = scan.nextLine();
//        String a = "abcde";
//        String b = "abgde";

        System.out.println(lengthOfCSB(a, b));
    }

    // 最长连续子串的长度
    private int lengthOfCSB(String a, String b) {
        int m = a.length();
        int n = b.length();
        int[][] dp = new int[m][n];
        for (int i = 0; i < n; i++) {
            if(a.charAt(0)==b.charAt(i))
                dp[0][i] = 1;
        }
        for (int i = 0; i < m; i++) {
            if(a.charAt(i)==b.charAt(0))
                dp[i][0] = 1;
        }
        PrintArray.print(dp);
        System.out.println();
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (a.charAt(i) == b.charAt(j)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        PrintArray.print(dp);
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res = res > dp[i][j] ? res : dp[i][j];
            }
        }
        return res;

    }


    public static void main(String[] args) {
        new Meutuan17_4().run();
    }
}
