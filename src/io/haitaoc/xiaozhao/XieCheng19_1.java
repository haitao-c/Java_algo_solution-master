package io.haitaoc.xiaozhao;


import java.util.Scanner;

public class XieCheng19_1 {

    public void run() {
        Scanner scan = new Scanner(System.in);
        long n = scan.nextLong();
        System.out.println(countOnes(n));

    }

    private int countOnes(long n) {
        String s = Long.toBinaryString(n);
       // System.out.println(s);
        int res = 0;
        for (int i = 0; i <s.length() ; i++) {
            if(s.charAt(i)=='1'){
                res++;
            }
        }
       return res;
    }


    public static void main(String[] args) {
        new XieCheng19_1().run();
    }
}
