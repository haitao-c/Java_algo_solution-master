package io.haitaoc.xiaozhao;

import java.util.Arrays;
import java.util.Scanner;

public class ZhaoHang19_2 {

    public void run() {
        Scanner scan = new Scanner(System.in);
        String[] s = scan.nextLine().split(" ");
        int n = s.length;
        int[] p = new int[n];
        for (int i = 0; i < s.length; i++) {
            p[i] = Integer.parseInt(s[i]);
        }
        int H = scan.nextInt();
        System.out.println(minSpeed(p, H));
    }

    private int minSpeed(int[] p, int H) {
        int K = 1;
        int count = 0;
        Arrays.sort(p);
        int min = p[0];
        int max = p[p.length - 1];
        for (; K <= max; K++) {
            for (int i = 0; i < p.length; i++) {
                if (p[i] % K == 0) {
                    count += p[i] / K;
                } else {
                    count += p[i] / K + 1;
                }
            }
            if (count <= H)
                break;
            count = 0;
        }

        return K;
    }


    public static void main(String[] args) {
        new ZhaoHang19_2().run();
    }
}
