package io.haitaoc.datastructure.unionFind;

import java.util.Random;

public class Main {
    private static double testUF(UF uf, int m) {

        int size = uf.getSize();
        Random random = new Random();

        long startTime = System.nanoTime();


        for (int i = 0; i < m; i++) {
            int a = random.nextInt(size);
            int b = random.nextInt(size);
            uf.unionElements(a, b);
        }

        for (int i = 0; i < m; i++) {
            int a = random.nextInt(size);
            int b = random.nextInt(size);
            uf.isConnected(a, b);
        }

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {
        int size = 100000;
        int m = 100000;

        // 第一个版本的unionFind问题: unionElements的时候需要遍历所有元素,效率较低, 属于Quick Find
        // UnionFind1 uf1 = new UnionFind1(size);
        // System.out.println("UnionFind1 : " + testUF(uf1, m) + " s");

        // 第二个版本的unionFind问题: find操作的消耗受树的高度影响, 最坏情况下可能成链表, 属于Quick Union
//        UnionFind2 uf2 = new UnionFind2(size);
//        System.out.println("UnionFind2 : " + testUF(uf2, m) + " s");

        // 第三个版本的unionFind问题: find操作的消耗受树的高度影响, 最坏情况下可能成链表, 属于Quick Union
        UnionFind3 uf3 = new UnionFind3(size);
        System.out.println("UnionFind3 : " + testUF(uf3, m) + " s");

        UnionFind4 uf4 = new UnionFind4(size);
        System.out.println("UnionFind4 : " + testUF(uf4, m) + " s");

        UnionFind5 uf5 = new UnionFind5(size);
        System.out.println("UnionFind5 : " + testUF(uf5, m) + " s");

        UnionFind6 uf6 = new UnionFind6(size);
        System.out.println("UnionFind6 : " + testUF(uf6, m) + " s");

    }
}
