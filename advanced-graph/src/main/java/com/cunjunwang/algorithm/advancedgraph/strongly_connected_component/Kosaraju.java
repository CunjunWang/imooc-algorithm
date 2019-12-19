package com.cunjunwang.algorithm.advancedgraph.strongly_connected_component;

import com.cunjunwang.algorithm.advancedgraph.Graph;
import com.cunjunwang.algorithm.advancedgraph.dfs.GraphDFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * 求有向图的强连通分量
 * <p>
 * Created by CunjunWang on 2019-12-18.
 */
public class Kosaraju {

    private Graph G;
    private int[] visited;
    private int sccCount = 0;

    public Kosaraju(Graph G) {
        if (!G.isDirected())
            throw new IllegalArgumentException("Only works for directed graph.");

        this.G = G;
        visited = new int[G.V()];
        Arrays.fill(visited, -1);

        // Kosaraju:
        // 1. 求图G的反图
        GraphDFS dfs = new GraphDFS(G.reverseGraph());

        // 2. 反图的后续遍历
        ArrayList<Integer> order = new ArrayList<>();
        for (int v : dfs.getPost())
            order.add(v);

        // 3. 后续遍历的逆序
        Collections.reverse(order);

        for (int v : order)
            if (visited[v] == -1) {
                dfs(v, sccCount);
                sccCount++;
            }
    }

    private void dfs(int v, int sccId) {
        visited[v] = sccId;
        for (int w : G.adj(v))
            if (visited[w] == -1)
                dfs(w, sccId);
    }

    public int getSccCount() {
        return sccCount;
    }

    public boolean isStronglyConnected(int v, int w) {
        G.validateVertex(v);
        G.validateVertex(w);
        return visited[v] == visited[w];
    }

    public ArrayList<Integer>[] components() {
        ArrayList<Integer>[] res = new ArrayList[sccCount];
        for (int i = 0; i < sccCount; i++)
            res[i] = new ArrayList<>();

        for (int v = 0; v < G.V(); v++)
            res[visited[v]].add(v);

        return res;
    }

    public static void main(String[] args) {

    }
}
