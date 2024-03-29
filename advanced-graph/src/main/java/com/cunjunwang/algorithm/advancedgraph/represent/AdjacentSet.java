package com.cunjunwang.algorithm.advancedgraph.represent;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * Created by CunjunWang on 2019-09-02.
 */
public class AdjacentSet {

    private int V; // vertex number
    private int E; // edge number
    private TreeSet<Integer>[] adjSet; // adjacent list

    /**
     * 构建邻接表
     * 使用红黑树 TreeSet:
     * 时间复杂度 O(E*lg(V)), 保持了数据存储的顺序性, 哈希表性能更优为O(1), 但没有顺序
     * 空间复杂度 O(V + E) 不可以理解为 O(E), 因为可能根本没有边
     * 缺点: 对于稀疏树, 浪费了太多空间
     *
     * @param filename
     */
    public AdjacentSet(String filename) {
        File file = new File(filename);
        try (Scanner scanner = new Scanner(file)) {
            V = scanner.nextInt();
            if (V < 0)
                throw new IllegalArgumentException("V must be non-negative");
            adjSet = new TreeSet[V];
            for (int i = 0; i < V; i++)
                adjSet[i] = new TreeSet<>();

            E = scanner.nextInt();
            if (E < 0)
                throw new IllegalArgumentException("E must be non-negative");
            for (int i = 0; i < E; i++) {
                int a = scanner.nextInt();
                validateVertex(a);
                int b = scanner.nextInt();
                validateVertex(b);

                // 判断自环边
                if (a == b)
                    throw new IllegalArgumentException("Self loop detected");

                // 判断平行边, 最坏 O(lg(V))
                if (adjSet[a].contains(b))
                    throw new IllegalArgumentException("Parallel edges detected");

                // O(lg(V))
                adjSet[a].add(b);
                adjSet[b].add(a);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 返回顶点数
     *
     * @return 顶点数
     */
    public int V() {
        return V;
    }

    /**
     * 返回边数
     *
     * @return 边数
     */
    public int E() {
        return E;
    }

    /**
     * 判断两个顶点之间是否有边
     * O(lg(V))
     *
     * @param v 顶点1
     * @param w 顶点2
     * @return 是否有边
     */
    public boolean hasEdge(int v, int w) {
        validateVertex(v);
        validateVertex(w);
        return adjSet[v].contains(w);
    }

    /**
     * 返回与v相邻的边
     * O(degree(v)), 最差O(V)
     *
     * @param v 顶点
     * @return 和v相邻的顶点集合
     */
    public Iterable<Integer> adj(int v) {
        validateVertex(v);
        return adjSet[v];
    }

    /**
     * 返回顶点的度
     *
     * @param v 顶点
     * @return 度数
     */
    public int degree(int v) {
        validateVertex(v);
        return adjSet[v].size();
    }

    /**
     * 判断顶点序号合法
     *
     * @param v 顶点序号
     */
    private void validateVertex(int v) {
        if (v < 0 || v > V)
            throw new IllegalArgumentException(String.format("Vertex %d is invalid", v));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("V = %d, E = %d\n", V, E));
        for (int v = 0; v < V; v++) {
            sb.append(String.format("%d : ", v));
            for (int w : adjSet[v])
                sb.append(String.format("%d ", w));
            sb.append("\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String filename = "./src/main/java/com/cunjunwang/algorithm/advancedgraph/represent/g.txt";
        AdjacentSet adjacentSet = new AdjacentSet(filename);
        System.out.println(adjacentSet.toString());
    }

}
