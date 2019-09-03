package com.cunjunwang.algorithm.advancedgraph.represent;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by CunjunWang on 2019-09-02.
 */
public class AdjacentList {

    private int V; // vertex number
    private int E; // edge number
    private LinkedList<Integer>[] adjList; // adjacent list

    /**
     * 构建邻接表
     * 时间复杂度 O(E)
     * 空间复杂度 O(V^2)
     * 缺点: 对于稀疏树, 浪费了太多空间
     *
     * @param filename
     */
    public AdjacentList(String filename) {
        File file = new File(filename);
        try (Scanner scanner = new Scanner(file)) {
            V = scanner.nextInt();
            if (V < 0)
                throw new IllegalArgumentException("V must be non-negative");
            adjList = new LinkedList[V];
            for (int i = 0; i < V; i++)
                adjList[i] = new LinkedList<>();

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

                // 判断平行边, 最坏 O(V)
                if (adjList[a].contains(b))
                    throw new IllegalArgumentException("Parallel edges detected");

                adjList[a].add(b);
                adjList[b].add(a);
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
     * O(1)
     *
     * @param v 顶点1
     * @param w 顶点2
     * @return 是否有边
     */
    public boolean hasEdge(int v, int w) {
        validateVertex(v);
        validateVertex(w);
        return adjList[v].contains(w);
    }

    /**
     * 返回与v相邻的边
     * O(V)
     *
     * @param v 顶点
     * @return 和v相邻的顶点集合
     */
    public LinkedList<Integer> adj(int v) {
        validateVertex(v);
        return adjList[v];
    }

    /**
     * 返回顶点的度
     *
     * @param v 顶点
     * @return 度数
     */
    public int degree(int v) {
        return adj(v).size();
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
            for (int w : adjList[v])
                sb.append(String.format("%d ", w));
            sb.append("\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String filename = "./src/main/java/com/cunjunwang/algorithm/advancedgraph/represent/g.txt";
        AdjacentList adjacentList = new AdjacentList(filename);
        System.out.println(adjacentList.toString());
    }

}
