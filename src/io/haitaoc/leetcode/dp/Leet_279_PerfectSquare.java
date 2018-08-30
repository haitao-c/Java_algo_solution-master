package io.haitaoc.leetcode.dp;

import java.util.Arrays;

public class Leet_279_PerfectSquare {
    /**
     * 判断一个数是否是完全平方数
     * 正则表达式进行匹配
     *
     * @param num
     * @return
     */
    private boolean isSqrt(double num) {
        String regex = "\\d+.0+";
        return (Math.sqrt(num) + "").matches(regex);
    }

    public int numSquares(int n) {
        // 1. 递归方法 return recursion(n);
        // 2. 记忆化搜索方法
        /*int[] memo = new int[n+1];
        Arrays.fill(memo,-1);
        return memorize(n,memo);*/
        // 3. 动态规划  1)超时
        /*int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i < n+1; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        for (int i = 2; i < n + 1; i++) {
            if(isSqrt(i)){
                dp[i] = 1;
                continue;
            }
            // 填充dp表
            for (int j = 1; j <= i - 1; j++) {
                if (isSqrt(j)) {
                    // i = j + (i-j)
                    dp[i] = Math.min(1+dp[i - j], dp[i]);
                }
            }
        }*/
        // 2) 所有的完美平方数都可以看做一个普通数加上一个完美平方数，那么递推式就变为了：dp[i + j * j] = Math.min(dp[i] + 1, dp[i + j * j])，
        int[] dp = new int[n + 1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        for (int i = 0; i*i <=n ; i++) {
            dp[i*i] = 1;
        }
        for(int i = 1; i <= n; i++) {  //选定第一个数为 i
            for(int j = 1; i + j * j <= n; j++) {  //选定另一个数为 j*j
                dp[i + j * j] = Math.min(dp[i] + 1, dp[i + j * j]);  //从小到大查找
            }
        }
        /*for (int i = 0; i < n+1; i++) {
            System.out.print(dp[i]+" ");
        }
        System.out.println();
        */
        return dp[n];

    }

    // 1. 递归解法
    private int recursive(int n) {
        if (isSqrt(n))
            return 1;
        // 赋给res初始值为无穷大，
        int res = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            if (isSqrt(i))
                // 因为递归的过程中，当前值可能会更小的值被取代,所以比较的参数中要有res当前值
                res = Math.min(res, 1 + recursive(n - i));
        }
        return res;
    }

    // 2.记忆化搜索方法
    private int memorize(int n, int[] memo) {
        if (isSqrt(n))
            return 1;
        if (memo[n] != -1)
            return memo[n];
        // 赋给res初始值为无穷大，
        int res = Integer.MAX_VALUE;

        for (int i = 1; i < n; i++) {
            if (isSqrt(i))
                // 因为递归的过程中，当前值可能会更小的值被取代,所以比较的参数中要有res当前值
                res = Math.min(res, 1 + memorize(n - i, memo));
        }
        memo[n] = res;
        return res;
    }


    public static void main(String... args) {
        System.out.println(new Leet_279_PerfectSquare().numSquares(12));
    }
}
