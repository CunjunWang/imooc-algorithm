package com.cunjunwang.algorithm.advancedgraph;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * 以TreeSet为底层实现的邻接表表示
 * Created by CunjunWang on 2019-09-02.
 */
public class Graph {

    private int V; // vertex number

    private int E; // edge number

    private TreeSet<Integer>[] adj; // adjacent list

    private boolean isDirected;

    private int[] indegrees, outdegrees;

    /**
     * 构建邻接表
     * 使用红黑树 TreeSet:
     * 时间复杂度 O(E*lg(V)), 保持了数据存储的顺序性, 哈希表性能更优为O(1), 但没有顺序
     * 空间复杂度 O(V + E) 不可以理解为 O(E), 因为可能根本没有边
     * 缺点: 对于稀疏树, 浪费了太多空间
     *
     * @param filename
     */
    public Graph(String filename, boolean isDirected) {

        this.isDirected = isDirected;

        File file = new File(filename);
        try (Scanner scanner = new Scanner(file)) {
            V = scanner.nextInt();
            if (V < 0)
                throw new IllegalArgumentException("V must be non-negative");
            adj = new TreeSet[V];
            for (int i = 0; i < V; i++)
                adj[i] = new TreeSet<>();

            indegrees = new int[V];
            outdegrees = new int[V];

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
                if (adj[a].contains(b))
                    throw new IllegalArgumentException("Parallel edges detected");

                // O(lg(V))
                adj[a].add(b); // a -> b
                if (isDirected) {
                    outdegrees[a]++; // a 出度增加
                    indegrees[b]++; // b 入度增加
                }

                if (!isDirected)
                    adj[b].add(a);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Graph(String filename) {
        this(filename, false);
    }

    public Graph(TreeSet<Integer>[] adj, boolean isDirected) {
        this.adj = adj;
        this.isDirected = isDirected;
        this.V = adj.length;
        this.E = 0;
        indegrees = new int[V];
        outdegrees = new int[V];
        for (int v = 0; v < V; v++)
            for (int w : adj[v]) {
                outdegrees[v]++;
                indegrees[w]++;
                this.E++;
            }

        if (!isDirected)
            this.E /= 2;
    }

    public boolean isDirected() {
        return this.isDirected;
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
        return adj[v].contains(w);
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
        return adj[v];
    }

    /**
     * 返回顶点的度，只适用于无向图
     *
     * @param v 顶点
     * @return 度数
     */
    public int degree(int v) {
        if (isDirected) {
            throw new RuntimeException("Degree only works on undirected graph");
        }
        validateVertex(v);
        return adj[v].size();
    }

    public int indegree(int v) {
        if (!isDirected) {
            throw new RuntimeException("Indegree only works on directed graph");
        }
        validateVertex(v);
        return indegrees[v];
    }

    public int outdegree(int v) {
        if (!isDirected) {
            throw new RuntimeException("Outdegree only works on directed graph");
        }
        validateVertex(v);
        return outdegrees[v];
    }

    public void removeEdge(int v, int w) {
        validateVertex(v);
        validateVertex(w);
        if (adj[v].contains(w)) {
            E--;

            if (isDirected) {
                outdegrees[v]--;
                indegrees[w]--;
            }
        }

        adj[v].remove(w);
        if (!isDirected)
            adj[w].remove(v);
    }

    /**
     * 判断顶点序号合法
     *
     * @param v 顶点序号
     */
    public void validateVertex(int v) {
        if (v < 0 || v > V)
            throw new IllegalArgumentException(String.format("Vertex %d is invalid", v));
    }

    public Graph reverseGraph() {
        TreeSet<Integer>[] rAdj = new TreeSet[V];
        for (int i = 0; i < V; i++)
            rAdj[i] = new TreeSet<>();

        for (int v = 0; v < V; v++)
            for (int w : adj(v))
                rAdj[w].add(v);

        return new Graph(rAdj, isDirected);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("V = %d, E = %d, directed = %b\n", V, E, isDirected));
        for (int v = 0; v < V; v++) {
            sb.append(String.format("%d : ", v));
            for (int w : adj[v])
                sb.append(String.format("%d ", w));
            sb.append("\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String filename = "./src/main/java/com/cunjunwang/algorithm/advancedgraph/test_graph/ug.txt";
        Graph g = new Graph(filename, true);
        System.out.println(g.toString());

        for (int v = 0; v < g.V(); v++) {
            System.out.println(g.indegrees[v] + " " + g.outdegrees[v]);
        }
    }
}
