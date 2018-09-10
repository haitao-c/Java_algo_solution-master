package io.haitaoc.xiaozhao;

import java.util.Scanner;

public class Meutuan17_1 {

    int res = 0;

    public void run() {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        methods(n);
        System.out.println(res);
    }

    private void methods(int n) {
        if (n == 0) {
            res++;
            return;
        }

        if (n < 0)
            return;

        for (int i = 1; i <= n; i++) {
            methods(n-i);
        }

    }


    public static void main(String[] args) {
        new Meutuan17_1().run();
    }
}
