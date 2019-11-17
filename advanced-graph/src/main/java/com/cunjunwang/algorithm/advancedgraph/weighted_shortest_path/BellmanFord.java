package com.cunjunwang.algorithm.advancedgraph.weighted_shortest_path;

import com.cunjunwang.algorithm.advancedgraph.WeightedGraph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by CunjunWang on 2019-11-17.
 */
public class BellmanFord {
    private WeightedGraph G;

    private int s;

    private int[] dis;

    private boolean hasNegativeCycle;

    private int[] pre;

    /*
     * 进行V-1轮松弛操作
     * 每次松弛操作要遍历每一条边
     *
     * O(V*E)
     */
    public BellmanFord(WeightedGraph G, int s) {
        this.G = G;
        G.validateVertex(s);
        this.s = s;

        dis = new int[G.V()];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[s] = 0;

        pre = new int[G.V()];
        Arrays.fill(pre, -1);

        hasNegativeCycle = false;

        // V - 1 次 relaxation
        for (int pass = 1; pass < G.V(); pass++) {

            for (int v = 0; v < G.V(); v++)
                for (int w : G.adj(v))
                    if (dis[v] != Integer.MAX_VALUE &&
                            dis[v] + G.getWeight(v, w) < dis[w]) {
                        dis[w] = dis[v] + G.getWeight(v, w);
                        pre[w] = v;
                    }
        }

        // 再多进行一轮松弛，如果发现还能更新，说明已经有负权环了
        for (int v = 0; v < G.V(); v++)
            for (int w : G.adj(v))
                if (dis[v] != Integer.MAX_VALUE &&
                        dis[v] + G.getWeight(v, w) < dis[w]) {
                    hasNegativeCycle = true;
                    break;
                }

    }

    public boolean isHasNegativeCycle() {
        return hasNegativeCycle;
    }

    public boolean isConnectedTo(int v) {
        G.validateVertex(v);
        return dis[v] != Integer.MAX_VALUE;
    }

    public int distTo(int v) {
        G.validateVertex(v);
        if (hasNegativeCycle)
            throw new RuntimeException("Has negative cycle");
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
        WeightedGraph g = new WeightedGraph("./src/main/java/com/cunjunwang/algorithm/advancedgraph/test_graph/bf_g.txt");
        BellmanFord bellmanFord = new BellmanFord(g, 0);

        if (!bellmanFord.hasNegativeCycle) {
            for (int v = 0; v < g.V(); v++)
                System.out.print(bellmanFord.distTo(v) + " ");
            System.out.println();
        } else {
            System.out.println("Has negative cycle");
        }

    }
}
