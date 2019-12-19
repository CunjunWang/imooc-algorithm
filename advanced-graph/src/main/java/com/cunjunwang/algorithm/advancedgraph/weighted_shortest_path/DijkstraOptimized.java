package com.cunjunwang.algorithm.advancedgraph.weighted_shortest_path;

import com.cunjunwang.algorithm.advancedgraph.WeightedGraph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Created by CunjunWang on 2019-11-17.
 */
public class DijkstraOptimized {
    private WeightedGraph G;

    // 源点s
    private int s;

    private int[] dis;

    private boolean[] visited;

    private int[] pre;

    private class Node implements Comparable<Node> {

        public int v, dis;

        public Node(int v, int dis) {
            this.v = v;
            this.dis = dis;
        }

        @Override
        public int compareTo(Node another) {
            return dis - another.dis;
        }
    }

    /*
     * 使用PQ优化
     *
     * O(E*log(E))
     */
    public DijkstraOptimized(WeightedGraph G, int s) {
        this.G = G;
        G.validateVertex(s);
        this.s = s;

        dis = new int[G.V()];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[s] = 0;

        pre = new int[G.V()];
        Arrays.fill(pre, -1);
        pre[s] = s;

        visited = new boolean[G.V()];
        Arrays.fill(visited, false);
        // 不可以给s的初始值设为true, 因为在while中，
        // 我们第一次要找的点就是这个s

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(s, 0));

        while (!pq.isEmpty()) {

            // 1. 找当前没有确定最短距离的点中，距离最小的那个点
            // O(logE) 最多的情况下，每一条边都加了一份关于另一个顶点的值
            int cur = pq.poll().v;
            if (visited[cur])
                continue;

            // 2. 确定cur这个点的最短路径
            visited[cur] = true;

            // 3. 从cur开始更新距离
            for (int w : G.adj(cur))
                if (!visited[w]) {
                    if (dis[cur] + G.getWeight(cur, w) < dis[w]) {
                        dis[w] = dis[cur] + G.getWeight(cur, w);
                        pre[w] = cur;

                        // 每个node可能在pq中有多份
                        pq.add(new Node(w, dis[w]));
                    }
                }
        }
    }

    public boolean isConnectedTo(int v) {
        G.validateVertex(v);
        return visited[v];
    }

    public int distTo(int v) {
        G.validateVertex(v);
        return dis[v];
    }

    public Iterable<Integer> path(int t) {
        ArrayList<Integer> res = new ArrayList<>();
        if (!isConnectedTo(t))
            return res;

        int cur = t;
        while (cur != s) {
            res.add(cur);
            cur = pre[cur];
        }
        res.add(s);
        Collections.reverse(res);
        return res;
    }

    public static void main(String[] args) {
        WeightedGraph g = new WeightedGraph("./src/main/java/com/cunjunwang/algorithm/advancedgraph/test_graph/dij_g.txt");
        DijkstraOptimized dijkstra = new DijkstraOptimized(g, 0);

        for (int v = 0; v < g.V(); v++)
            System.out.print(dijkstra.distTo(v) + " ");
        System.out.println();

        System.out.println(dijkstra.path(3));
    }

}
