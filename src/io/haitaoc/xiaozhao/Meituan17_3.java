package io.haitaoc.xiaozhao;

import java.util.Scanner;

public class Meituan17_3 {

    public void run(){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] h = new int[n];
        for (int i = 0; i <n ; i++) {
            h[i] = scan.nextInt();
        }
        System.out.println(maxAera(h));

    }

    private int maxAera(int[] h){
        int max = 0;
        for (int i = 0; i <h.length ; i++) {
            int minHeight = h[i];
            for (int j = i+1; j < h.length; j++) {
                minHeight = Math.min(minHeight,h[j]);
                max = Math.max(minHeight * (j-i+1),max);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        new Meituan17_3().run();
    }
}
