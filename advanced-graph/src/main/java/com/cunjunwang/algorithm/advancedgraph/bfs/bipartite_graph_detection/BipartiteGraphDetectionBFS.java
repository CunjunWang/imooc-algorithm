package com.cunjunwang.algorithm.advancedgraph.bfs.bipartite_graph_detection;

import com.cunjunwang.algorithm.advancedgraph.Graph;
import com.cunjunwang.algorithm.advancedgraph.dfs.bipartite_graph_detection.BipartiteGraphDetection;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 用bfs判断二分图, 染色问题
 * Created by CunjunWang on 2019-09-05.
 */
public class BipartiteGraphDetectionBFS {

    private Graph G;

    private int[] colors; // 染色的结果

    private boolean isBipartite = true;

    public BipartiteGraphDetectionBFS(Graph G) {
        this.G = G;
        colors = new int[G.V()];
        for (int i = 0; i < G.V(); i++) {
            colors[i] = -1;
        }
        for (int v = 0; v < G.V(); v++)
            if (colors[v] == -1 && !bfs(v)) {
                isBipartite = false;
                break;
            }
    }

    /**
     * 对Graph进行广度优先遍历, 进行染色
     * O(V + E)
     *
     * @param v     节点
     */
    private boolean bfs(int v) {
        Queue<Integer> todo = new LinkedList<>();
        todo.add(v);
        colors[v] = 0;
        while (!todo.isEmpty()) {
            int cur = todo.remove();
            for (int w : G.adj(cur))
                if (colors[w] == -1) {
                    todo.add(w);
                    colors[w] = 1 - colors[cur];
                } else if (colors[w] == colors[cur]) {
                    return false;
                }
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
