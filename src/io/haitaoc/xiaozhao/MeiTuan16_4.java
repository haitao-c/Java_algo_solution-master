package io.haitaoc.xiaozhao;

public class MeiTuan16_4 {

    public int countArea(int[] A, int n) {
        int minHeight;
        int max = A[0];
        for (int i = 0; i <A.length ; i++) {
            minHeight = A[i];
            for (int j = i+1; j <A.length ; j++) {
                minHeight = A[j]>minHeight?minHeight:A[j];
                max = minHeight*(j-i+1)>max?minHeight*(j-i+1):max;
            }
        }
        return max;

    }

    public static void main(String[] args) {
            int[] A={2,7,9,4,1};
            int n = 5;
        System.out.println(new MeiTuan16_4().countArea(A,n));
    }
}
