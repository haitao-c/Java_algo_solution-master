package io.haitaoc.xiaozhao;

import java.util.Arrays;
import java.util.Scanner;

public class ZhaoHang_3 {

    int max=-1;
    int[] memo;

    public void run(){
        Scanner scan = new Scanner(System.in);
        int num= scan.nextInt();
        memo=new int[num+1];
        Arrays.fill(memo,-1);

        System.out.println(product(num));

    }

    private int max3(int a,int b, int c){
        return Math.max(a,Math.max(b,c));
    }

    private int product(int num){
        if(num==1)
            return 1;

        if(memo[num]!=-1)
            return memo[num];

        int res = -1;
        for (int i = 1; i <num; i++)
            res=max3(res,i*(num-i), i*product(num-i));
        memo[num] = res;

        return res;
    }

    public static void main(String[] args) {
        new ZhaoHang_3().run();
    }
}
