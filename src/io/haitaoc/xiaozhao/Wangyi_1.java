package io.haitaoc.xiaozhao;

import java.util.Scanner;

public class Wangyi_1 {

    public void run() {
        Scanner scan = new Scanner(System.in);
        long n = scan.nextLong();
        long k = scan.nextLong();
        long res = 0;
        if (n < 1 || n > (long) Math.pow(10, 5) || k < 0 || k > (n - 1)) {
            System.out.println(res);
            return;
        }

        /* 超时
        for (int i = 0; i <= n; i++) {
            for (int j = k; j <= n; j++) {
                if (j != 0 && i % j >= k) {
                        res++;
                    }
                }
            }*/

        /** 因为余数是k一定小于y, 所以y>=k+1
         *  余数的含义: 将n个1按y一组来分, 分成的对数为x, 剩余的个数为k
         *  比如  k=3, n=11 当y=4时
         *
         *  1 2 3 4| 5 6 7 8 | 9 10 11
         *  1 2 3 0| 1 2 3 0 | 1 2 3
         *  所以 n/y就是分成的区间个数, 由于要求x%y >=k, 所以一个区间内有y-k个x满足要求
         *  第二, 区间可能向上面那样不能完整划分, 要判断余出来的区间有几个
         *  用 n%y得到余数t, 若t>=k, 说明最后一个区间内有t-k+1个
         */

        if (k == 0) {
            res = n * n;
        } else {
            for (long y = k + 1; y <= n; y++) {
                res += n / y * (y - k);
                if (n % y >= k)
                    res += n % y - k + 1;
            }
        }

        System.out.println(res);
    }

    public static void main(String[] args) {
        new Wangyi_1().run();
    }
}
