package com.cunjunwang.algorithm.advancedgraph.bridge.find_bridge;

/**
 * Created by CunjunWang on 2019-09-09.
 */
public class Edge {

    private int v, w; // 边的两个端点

    public Edge(int v, int w) {
        this.v = v;
        this.w = w;
    }

    @Override
    public String toString() {
        return String.format("%d-%d", v, w);
    }
}
