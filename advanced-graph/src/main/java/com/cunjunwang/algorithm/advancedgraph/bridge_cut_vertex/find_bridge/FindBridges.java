package com.cunjunwang.algorithm.advancedgraph.bridge_cut_vertex.find_bridge;

import com.cunjunwang.algorithm.advancedgraph.Graph;

import java.util.ArrayList;

/**
 * 通过dfs寻找图的桥
 * Created by CunjunWang on 2019-09-09.
 */
public class FindBridges {

    private Graph G;

    private boolean[] visited;

    private int[] ord;

    private int[] low;

    private int cnt; // 当前遍历了多少个顶点

    private ArrayList<Edge> res;

    public FindBridges(Graph G) {
        this.G = G;
        visited = new boolean[G.V()];
        ord = new int[G.V()];
        low = new int[G.V()];
        cnt = 0;
        res = new ArrayList<>();

        for (int v = 0; v < G.V(); v++)
            if (!visited[v])
                dfs(v, v);
    }

    /**
     * 对Graph进行深度优先遍历
     * O(V + E)
     *
     * @param v      当前节点
     * @param parent 父亲节点
     */
    private void dfs(int v, int parent) {
        visited[v] = true;
        ord[v] = cnt;
        low[v] = ord[v];
        cnt++;

        for (int w : G.adj(v)) {
            if (!visited[w]) {
                dfs(w, v);
                low[v] = Math.min(low[v], low[w]);
                // v-w是新的边, 要判断是不是桥
                if (low[w] > ord[v]) {
                    // 找到了桥
                    res.add(new Edge(v, w));
                }
            } else {
                if (w != parent) {
                    low[v] = Math.min(low[v], low[w]);
                }
            }
        }
    }

    /**
     * 获得桥列表
     *
     * @return 桥列表
     */
    public ArrayList<Edge> getRes() {
        return res;
    }

    public static void main(String[] args) {
        String filename = "./src/main/java/com/cunjunwang/algorithm/advancedgraph/g4.txt";
        Graph G = new Graph(filename);
        FindBridges findBridges = new FindBridges(G);
        System.out.println("Bridges: " + findBridges.getRes());
    }

}
