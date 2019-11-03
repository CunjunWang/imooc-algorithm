package com.cunjunwang.algorithm.advancedgraph.topological_sort;

import com.cunjunwang.algorithm.advancedgraph.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by CunjunWang on 2019-11-03.
 */
public class TopologicalSort {

    private Graph G;

    private ArrayList<Integer> res;

    private boolean hasCycle = false;

    public TopologicalSort(Graph G) {
        if (!G.isDirected())
            throw new IllegalArgumentException("Topological sort only applies to directed graph!");

        this.G = G;

        res = new ArrayList<>();

        // initial vertices to sort
        Queue<Integer> q = new LinkedList<>();
        int[] indegrees = new int[G.V()];
        for (int v = 0; v < G.V(); v++) {
            indegrees[v] = G.indegree(v);
            if (indegrees[v] == 0)
                q.offer(v);
        }

        while (!q.isEmpty()) {
            int cur = q.remove();
            res.add(cur);

            for (int next : G.adj(cur)) {
                indegrees[next]--;
                if (indegrees[next] == 0)
                    q.add(next);
            }
        }

        if (res.size() != G.V()) {
            hasCycle = true;
            res.clear();
        }

    }

    public boolean hasCycle() {
        return this.hasCycle;
    }

    public ArrayList<Integer> getRes() {
        return this.res;
    }
}
