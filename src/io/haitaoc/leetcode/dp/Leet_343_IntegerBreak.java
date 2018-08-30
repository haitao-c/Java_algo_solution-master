package io.haitaoc.leetcode.dp;

import java.util.Arrays;

/**
 * 暴力递归举例：分割4的最大乘积={1+分割3的最大乘积}/{2+分割2的最大乘积}/{3+分割1的最大乘积}
 */
public class Leet_343_IntegerBreak {

    public int integerBreak(int n) {
        //1. 递归思想 return breakInteger(n);
        int[] memo = new int[n+1];
        // 对数组memo的每个元素赋予相同值
        Arrays.fill(memo,-1);
        //2. 记忆化搜索   return breakInteger2(n,memo);
        //3. 动态规划方法：memo[i]表示将数字i分割(至少分割两部分)后得到的最大乘积
        memo[1] = 1;
        for (int i = 2; i <n+1 ; i++) {
            //求解memo[i]
            for (int j = 1; j <=i-1 ; j++) {
                //j+(i-j)
                //memo[i] =Math.max(j*memo[i-j],j*(i-j));
                memo[i] =max3(j*memo[i-j],j*(i-j),memo[i]);
            }
        }
        return memo[n];
    }
    private int max3(int a,int b, int c){
        return Math.max(a,Math.max(b,c));
    }
    // 1. 递归法
    // breakInteger 至少将n分成两份乘积 所以  breakInteger(n-i) 中不包括i*n-i
    private int breakInteger(int n) {
        if(n==1) return 1;

        //取一个res变量保存最大值
        int res =-1;
        for (int i = 1; i < n; i++)
            res = max3(res,i*(n-i),i*breakInteger(n-i));
        return res;
    }
    // 2. 记忆化搜索方法
    // breakInteger2 至少将n分成两份乘积 所以  breakInteger(n-i) 中不包括i*n-i

    private int breakInteger2(int n,int[] memo) {
        if(n==1) return 1;

        if(memo[n]!=-1)
            return memo[n];

        //取一个res变量保存最大值
        int res =-1;

        for (int i = 1; i < n; i++)
            res = max3(res,i*(n-i),i*breakInteger(n-i));
        memo[n]= res;
        return res;
    }

    public static void main(String...args){
        int n=10;
        System.out.println(new Leet_343_IntegerBreak().integerBreak(n));
    }
}
