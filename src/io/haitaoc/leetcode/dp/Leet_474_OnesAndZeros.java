package io.haitaoc.leetcode.dp;


// 01背包问题的变种
// 问题即为从Array中拿出字符串使得0的个数不超过m,1的个数不超过n
// dp[i][m][n] = dp[i-1][m][n]
//             = dp[i-1][m-zeros][n-ones]
public class Leet_474_OnesAndZeros {
    public int findMaxForm(String[] strs, int m, int n) {
        if (strs.length == 0 || strs == null)
            return 0;
        int nums = strs.length;
        int[][][] dp = new int[nums][m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                int[] count = count(strs[0]);
                if (count[0] <= i && count[1] <= j)
                    dp[0][i][j] = 1;
            }
        }
        for (int i = 1; i < nums; i++) {
            for (int j = 0; j <= m; j++) {
                for (int k = 0; k <= n; k++) {
                    int[] count = count(strs[i]);
                    if (j >= count[0] && k >= count[1])
                        dp[i][j][k] = Math.max(dp[i - 1][j][k], dp[i-1][j - count[0]][k - count[1]]+1);
                    else
                        dp[i][j][k] = dp[i - 1][j][k];
                }
            }
        }
        return dp[nums - 1][m][n];
    }

    private int[] count(String s) {
        int[] count = new int[2];
        int length = s.length();
        for (int i = 0; i < length; i++) {
            if (s.charAt(i) == '0')
                count[0]++;
            else
                count[1]++;
        }
        return count;
    }

    public static void main(String... args) {
        String[] strs = {"10","0001","111001","1","0"};
        int m = 5;
        int n = 3;
        System.out.println(new Leet_474_OnesAndZeros().findMaxForm(strs, m, n));
    }
}
