package com.cunjunwang.algorithm.advancedgraph.weighted_shortest_path;

import com.cunjunwang.algorithm.advancedgraph.WeightedGraph;

import java.util.Arrays;

/**
 * Created by CunjunWang on 2019-11-17.
 */
public class Dijkstra {

    private WeightedGraph G;

    // 源点s
    private int s;

    private int[] dis;

    private boolean[] visited;

    public Dijkstra(WeightedGraph G, int s) {
        this.G = G;
        G.validateVertex(s);
        this.s = s;

        dis = new int[G.V()];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[s] = 0;

        visited = new boolean[G.V()];
        Arrays.fill(visited, false);
        // 不可以给s的初始值设为true, 因为在while中，
        // 我们第一次要找的点就是这个s

        while (true) {
            // 1. 找当前没有确定最短距离的点钟，距离最小的那个点
            int curDis = Integer.MAX_VALUE;
            int cur = -1;
            for (int v = 0; v < G.V(); v++)
                if (!visited[v] && dis[v] < curDis) {
                    curDis = dis[v];
                    cur = v;
                }

            if (cur == -1)
                break;

            // 2. 确定cur这个点的最短路径
            visited[cur] = true;

            // 3. 从cur开始更新距离
            for (int w : G.adj(cur))
                if (!visited[w]) {
                    if (dis[cur] + G.getWeight(cur, w) < dis[w])
                        dis[w] = dis[cur] + G.getWeight(cur, w);
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

    public static void main(String[] args) {
        WeightedGraph g = new WeightedGraph("./src/main/java/com/cunjunwang/algorithm/advancedgraph/test_graph/dij_g.txt");
        Dijkstra dijkstra = new Dijkstra(g, 0);

        for (int v = 0; v < g.V(); v++)
            System.out.print(dijkstra.distTo(v) + " ");
        System.out.println();
    }

}
