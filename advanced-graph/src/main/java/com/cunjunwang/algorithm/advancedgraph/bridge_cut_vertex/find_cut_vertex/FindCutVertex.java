package com.cunjunwang.algorithm.advancedgraph.bridge_cut_vertex.find_cut_vertex;

import com.cunjunwang.algorithm.advancedgraph.Graph;

import java.util.ArrayList;

/**
 * 通过dfs寻找图的割点
 * Created by CunjunWang on 2019-09-11.
 */
public class FindCutVertex {

    private Graph G;
    private boolean[] visited;

    private int[] ord;
    private int[] low;
    private int cnt; // 当前遍历了多少个顶点

    private ArrayList<Integer> res;

    public FindCutVertex(Graph G) {
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

        int child = 0;
        for (int w : G.adj(v)) {
            if (!visited[w]) {
                dfs(w, v);
                low[v] = Math.min(low[v], low[w]);

                // v 不可以是根节点, 根节点有单独判断
                if (v != parent && low[w] >= ord[v]) {
                    // 找到了割点
                    res.add(v);
                }

                child++;
                if (v == parent && child >= 2 && !res.contains(v)) {
                    res.add(v);
                }

            } else {
                if (w != parent) {
                    low[v] = Math.min(low[v], low[w]);
                }
            }
        }
    }

    /**
     * 获得割点列表
     *
     * @return 割点列表
     */
    public ArrayList<Integer> getRes() {
        return res;
    }

    public static void main(String[] args) {
        String filename = "./src/main/java/com/cunjunwang/algorithm/advancedgraph/g4.txt";
        Graph G = new Graph(filename);
        FindCutVertex findCutVertex = new FindCutVertex(G);
        System.out.println("Cut points: " + findCutVertex.getRes());
    }

}
