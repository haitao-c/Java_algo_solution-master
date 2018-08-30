package io.haitaoc.leetcode.dp;

public class Leet_91_DecodeWays {
    public int numDecodings(String s) {
        // invalid sequence
        if (s == null || s.length() <= 0 || s.charAt(0) == '0') {
            return 0;
        }

        int[] dp = new int[s.length() + 1];
        // init
        dp[0] = 1;
        dp[1] = 1;

        int i = 2;
        for (; i < dp.length; i++) {
            // current character
            char end = s.charAt(i - 1);
            if (end == '0') {

                char pre = s.charAt(i - 2);
                // invalid sequence if character right before '0' is not '1' or '2'
                // no need to check further
                if (pre != '1' && pre != '2') {
                    return 0;
                }

                dp[i] = dp[i - 2];
            } else {
                dp[i] = dp[i - 1];
                // 2 digits in range (10, 20) (20, 26] is valid
                int num = Integer.parseInt(s.substring(i - 2, i));
                if (num > 10 && num < 20 || num > 20 && num <= 26) {
                    dp[i] += dp[i - 2];
                }
            }
        }

        return dp[i - 1];
    }

    public static void main(String... args) {
        System.out.println(new Leet_91_DecodeWays().numDecodings("012"));
    }
}
