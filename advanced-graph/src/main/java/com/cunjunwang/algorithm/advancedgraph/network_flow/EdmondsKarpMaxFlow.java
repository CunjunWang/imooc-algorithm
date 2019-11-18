package com.cunjunwang.algorithm.advancedgraph.network_flow;

import com.cunjunwang.algorithm.advancedgraph.WeightedGraph;

import java.util.*;

/**
 * 根据Ford-Fulkerson框架实现Edmonds-Karp算法
 * <p>
 * Created by CunjunWang on 2019-11-18.
 */
public class EdmondsKarpMaxFlow {

    private WeightedGraph network;

    // source and target
    private int s, t;

    private int maxFlow;

    private WeightedGraph residualGraph;

    public EdmondsKarpMaxFlow(WeightedGraph network, int s, int t) {
        if (!network.isDirected())
            throw new IllegalArgumentException("Max flow works only on directed graph.");

        if (network.V() < 2)
            throw new IllegalArgumentException("Max flow works need at least 2 vertices.");

        network.validateVertex(s);
        network.validateVertex(t);

        if (s == t)
            throw new IllegalArgumentException("Source and target cannot be the same.");

        maxFlow = 0;
        this.network = network;
        this.s = s;
        this.t = t;

        this.residualGraph = new WeightedGraph(network.V(), true);

        for (int v = 0; v < network.V(); v++)
            for (int w : network.adj(v)) {
                int c = network.getWeight(v, w);
                residualGraph.addEdge(v, w, c);
                residualGraph.addEdge(w, v, 0);
            }

        // 不断在残量图中找增广路径
        while (true) {

            // 找增广路径
            ArrayList<Integer> augPath = getAugmentedPath();
            if (augPath == null || augPath.size() == 0)
                break;

            // 计算增广路径上的最小权值
            int f = Integer.MAX_VALUE;
            for (int i = 1; i < augPath.size(); i++) {
                int v = augPath.get(i - 1);
                int w = augPath.get(i);
                int weight = residualGraph.getWeight(v, w);
                f = Math.min(f, weight);
            }

            // 添加流量
            maxFlow += f;

            // 更新残量图
            for (int i = 1; i < augPath.size(); i++) {
                int v = augPath.get(i - 1);
                int w = augPath.get(i);

                if (network.hasEdge(v, w)) {
                    residualGraph.setWeight(v, w,
                            residualGraph.getWeight(v, w) - f);
                    residualGraph.setWeight(w, v,
                            residualGraph.getWeight(w, v) + f);
                } else {
                    residualGraph.setWeight(w, v,
                            residualGraph.getWeight(w, v) + f);
                    residualGraph.setWeight(v, w,
                            residualGraph.getWeight(v, w) - f);
                }
            }

        }
    }

    private ArrayList<Integer> getAugmentedPath() {
        // 本质是 BFS
        Queue<Integer> q = new LinkedList<>();
        int[] pre = new int[network.V()];
        Arrays.fill(pre, -1);

        q.add(s);
        pre[s] = s;

        while (!q.isEmpty()) {
            int cur = q.remove();
            if (cur == t)
                break;
            for (int next : residualGraph.adj(cur))
                if (pre[next] == -1 &&
                        residualGraph.getWeight(cur, next) > 0) {
                    pre[next] = cur;
                    q.add(next);
                }
        }

        ArrayList<Integer> result = new ArrayList<>();
        if (pre[t] == -1)
            return result;

        int cur = t;
        while (cur != s) {
            result.add(cur);
            cur = pre[cur];
        }
        result.add(s);
        Collections.reverse(result);
        return result;
    }

    public int getMaxFlow() {
        return this.maxFlow;
    }

    public int flow(int v, int w) {
        if (!network.hasEdge(v, w))
            throw new IllegalArgumentException("No such edge");

        return residualGraph.getWeight(w, v);
    }

}
