package com.cunjunwang.algorithm.advancedgraph.dfs.bipartite_graph_detection;

import com.cunjunwang.algorithm.advancedgraph.Graph;

/**
 * 利用dfs判断一张图是否是二分图, 染色问题
 * Created by CunjunWang on 2019-09-04.
 */
public class BipartiteGraphDetection {

    private Graph G;

    private int[] colors; // 染色的结果

    private boolean isBipartite = true;

    public BipartiteGraphDetection(Graph G) {
        this.G = G;
        colors = new int[G.V()];
        for (int i = 0; i < G.V(); i++) {
            colors[i] = -1;
        }
        for (int v = 0; v < G.V(); v++)
            if (colors[v] == -1 && !dfs(v, 0)) {
                isBipartite = false;
                break;
            }
    }

    /**
     * 对Graph进行深度优先遍历, 进行染色
     * 递归写法
     * O(V + E)
     *
     * @param v     节点
     * @param color 颜色
     */
    private boolean dfs(int v, int color) {
        colors[v] = color;
        for (int w : G.adj(v))
            if (colors[w] == -1 && !dfs(w, 1 - color)) {
                return false;
            } else if (colors[w] == colors[v]) {
                return false;
            }
        return true;
    }

    /**
     * 返回该图是否是二分图
     *
     * @return 是否是二分图
     */
    public boolean isBipartite() {
        return isBipartite;
    }

    public static void main(String[] args) {
        String filename = "./src/main/java/com/cunjunwang/algorithm/advancedgraph/g1.txt";
        Graph G = new Graph(filename);
        BipartiteGraphDetection bipartiteGraphDetection = new BipartiteGraphDetection(G);
        System.out.println(bipartiteGraphDetection.isBipartite());
    }

}
