package io.haitaoc.xiaozhao;

public class NULL {

    public static void print() {
        System.out.println("MTDP");
    }

    public static void main(String[] args) {
        try {
            ((NULL) null).print();
        } catch (NullPointerException e) {
            System.out.println("NullPointerException");
        }

        System.out.println(zeroCount(1024));

    }

    public static int zeroCount(int n) {
        int res = 0;
        while (n != 0) {
            n = (n) / 5;
            res += n;
        }
        return res;
    }

}

