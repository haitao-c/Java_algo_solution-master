package io.haitaoc.xiaozhao;

import java.util.Scanner;

public class MeiTuan16_1 {

    public int getDis(int[] A, int n) {
        int max = 0;
        for (int i = 0; i <n ; i++) {
            for (int j = i+1; j <n ; j++) {
                if(A[j]-A[i]>=max)
                    max = A[j]-A[i];
            }
        }
        return max;
    }
    public static void main(String[] args) {
        System.out.println(new MeiTuan16_1().getDis(new int[]{10,5},2));
    }
}
