package com.cunjunwang.algorithm.advancedgraph.network_flow;

import com.cunjunwang.algorithm.advancedgraph.WeightedGraph;

import java.util.ArrayList;

/**
 * 最大流问题的Ford-Fulkerson思想代码框架
 * <p>
 * Created by CunjunWang on 2019-11-18.
 */
public class FordFulkersonFrame {

    private WeightedGraph network;

    // source and target
    private int s, t;

    private int maxFlow;

    private WeightedGraph residualGraph;

    public FordFulkersonFrame(WeightedGraph network, int s, int t) {
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

            ArrayList<Integer> augPath = getAugmentedPath();
            if (augPath == null || augPath.size() == 0)
                break;

            int f = Integer.MAX_VALUE;
            // TODO: 计算增广路径上的最小权值

            maxFlow += f;

            // TODO: 更新残量图

        }
    }

    private ArrayList<Integer> getAugmentedPath() {
        return null;
    }

}
