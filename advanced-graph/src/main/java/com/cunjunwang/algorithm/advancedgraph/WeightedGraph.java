package com.cunjunwang.algorithm.advancedgraph;

/**
 * Created by CunjunWang on 2019-10-30.
 */

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * 以TreeSet为底层实现的邻接表表示
 * Created by CunjunWang on 2019-09-02.
 */
public class WeightedGraph implements Cloneable {

    private int V; // vertex number
    private int E; // edge number

    // map<vertex, weight>
    private TreeMap<Integer, Integer>[] adj; // adjacent list

    private boolean isDirected;

    /**
     * 构建邻接表
     * 使用红黑树 TreeMap:
     * 时间复杂度 O(E*lg(V)), 保持了数据存储的顺序性, 哈希表性能更优为O(1), 但没有顺序
     * 空间复杂度 O(V + E) 不可以理解为 O(E), 因为可能根本没有边
     * 缺点: 对于稀疏树, 浪费了太多空间
     *
     * @param filename
     */
    public WeightedGraph(String filename, boolean isDirected) {
        File file = new File(filename);
        try (Scanner scanner = new Scanner(file)) {
            V = scanner.nextInt();
            if (V < 0)
                throw new IllegalArgumentException("V must be non-negative");
            adj = new TreeMap[V];
            for (int i = 0; i < V; i++)
                adj[i] = new TreeMap<Integer, Integer>();

            int e = scanner.nextInt();
            if (e < 0)
                throw new IllegalArgumentException("E must be non-negative");

            E = 0;
            for (int i = 0; i < e; i++) {
                int a = scanner.nextInt();
                int b = scanner.nextInt();
                int weight = scanner.nextInt();

                addEdge(a, b, weight);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public WeightedGraph(String filename) {
        this(filename, false);
    }

    public WeightedGraph(int V, boolean isDirected) {
        this.V = V;
        this.isDirected = isDirected;
        this.E = 0;

        adj = new TreeMap[V];
        for (int i = 0; i < V; i++)
            adj[i] = new TreeMap<>();
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
        return adj[v].containsKey(w);
    }

    public void addEdge(int a, int b, int v) {
        validateVertex(a);
        validateVertex(b);

        // 判断自环边
        if (a == b)
            throw new IllegalArgumentException("Self loop detected");

        // 判断平行边, 最坏 O(lg(V))
        if (adj[a].containsKey(b))
            throw new IllegalArgumentException("Parallel edges detected");

        // O(lg(V))
        adj[a].put(b, v);

        if (!isDirected)
            adj[b].put(a, v);

        this.E++;
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
        return adj[v].keySet();
    }

    /**
     * 获得边的权值
     *
     * @param v
     * @param w
     * @return
     */
    public int getWeight(int v, int w) {
        if (hasEdge(v, w)) {
            return adj[v].get(w);
        } else {
            throw new IllegalArgumentException("Invalid vertex, no such edge");
        }
    }

    public void setWeight(int v, int w, int newWeight) {
        if (!hasEdge(v, w))
            throw new IllegalArgumentException("Invalid vertex, no such edge");
        else
            adj[v].put(w, newWeight);

        if (!isDirected)
            adj[w].put(v, newWeight);
    }

    /**
     * 返回顶点的度
     *
     * @param v 顶点
     * @return 度数
     */
    public int degree(int v) {
        validateVertex(v);
        return adj[v].size();
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("V = %d, E = %d, directed = %b\n", V, E, isDirected));
        for (int v = 0; v < V; v++) {
            sb.append(String.format("%d : ", v));
            for (Map.Entry<Integer, Integer> entry : adj[v].entrySet())
                sb.append(String.format("(%d: %d) ",
                        entry.getKey(), entry.getValue()));
            sb.append("\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String filename = "./src/main/java/com/cunjunwang/algorithm/advancedgraph/g.txt";
        WeightedGraph g = new WeightedGraph(filename, true);
        System.out.println(g);
    }

}
