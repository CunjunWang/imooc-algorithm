package com.cunjunwang.algorithm.advanceddatastructure.union_find;

import java.util.Random;

/**
 * Created by CunjunWang on 2019-09-03.
 */
public class Test {

    private static double testUF(UnionFind unionFind, int m) {
        int size = unionFind.getSize();
        Random random = new Random();
        long startTime = System.nanoTime();

        for (int i = 0; i < m; i++) {
            int a = random.nextInt(size);
            int b = random.nextInt(size);
            unionFind.unionElements(a, b);
        }

        for (int i = 0; i < m; i++) {
            int a = random.nextInt(size);
            int b = random.nextInt(size);
            unionFind.isConnected(a, b);
        }

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {
        int size = 10000000;
        int m = 10000000;

//        UnionFind unionFindQuickFind = new UnionFindQuickFind(size);
//        System.out.println("Union Find Quick Find: " + testUF(unionFindQuickFind, m) + " s");
//
//        UnionFind unionFindQuickUnion = new UnionFindQuickUnion(size);
//        System.out.println("Union Find Quick Union: " + testUF(unionFindQuickUnion, m) + " s");

        UnionFind unionFindOptSize = new UnionFindOptSize(size);
        System.out.println("Union Find size optimized: " + testUF(unionFindOptSize, m) + " s");

        UnionFind unionFindOptRank = new UnionFindOptRank(size);
        System.out.println("Union Find rank optimized: " + testUF(unionFindOptRank, m) + " s");

        UnionFind unionFindPathCompression = new UnionFindPathCompression(size);
        System.out.println("Union Find path compression: " + testUF(unionFindPathCompression, m) + " s");

        UnionFind unionFindOptPathCompression = new UnionFindOptPathCompression(size);
        System.out.println("Union Find opt path compression: " + testUF(unionFindOptPathCompression, m) + " s");

    }
}
