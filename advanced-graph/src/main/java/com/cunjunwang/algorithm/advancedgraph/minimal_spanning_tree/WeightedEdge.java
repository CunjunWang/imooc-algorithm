package com.cunjunwang.algorithm.advancedgraph.minimal_spanning_tree;

import lombok.Data;

/**
 * Created by CunjunWang on 2019-10-30.
 */
@Data
public class WeightedEdge implements Comparable<WeightedEdge> {

    private int v, w, weight;

    public WeightedEdge(int v, int w, int weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return String.format("(%d-%d: %d)", v, w, weight);
    }

    @Override
    public int compareTo(WeightedEdge another) {
        return this.weight - another.weight;
    }

}
