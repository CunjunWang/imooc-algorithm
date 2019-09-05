package com.cunjunwang.algorithm.advancedgraph.dfs.undirected_graph_cycle_detection;

import com.cunjunwang.algorithm.advancedgraph.Graph;

/**
 * 无向图的环检测, 基于dfs
 * Created by CunjunWang on 2019-09-04.
 */
public class UndirectedGraphCycleDetect {

    private Graph G;

    private boolean[] visited;

    private boolean hasCycle;

    public UndirectedGraphCycleDetect(Graph G) {
        this.G = G;
        this.hasCycle = false;
        visited = new boolean[G.V()];
        for (int v = 0; v < G.V(); v++)
            if (!visited[v] && dfs(v, v)) {
                hasCycle = true;
                break;
            }
    }

    /**
     * 对Graph进行深度优先遍历, 检测是否有环
     * 递归写法
     * O(V + E)
     *
     * @param v      当前节点
     * @param parent 上一个节点
     * @return 从v开始遍历, 是否有环
     */
    private boolean dfs(int v, int parent) {
        visited[v] = true;
        for (int w : G.adj(v)) {
            if (!visited[w] && dfs(w, v)) {
                return true;
            } else if (w != parent) {
                // 当前w访问过, 而且不是v的上一个节点, 那么就找到环了
                return true;
            }
        }
        return false;
    }

    /**
     * 返回图是否有环
     *
     * @return 是否有环
     */
    public boolean hasCycle() {
        return hasCycle;
    }

    public static void main(String[] args) {
        String filename = "./src/main/java/com/cunjunwang/algorithm/advancedgraph/g.txt";
        Graph G = new Graph(filename);
        UndirectedGraphCycleDetect cycleDetect = new UndirectedGraphCycleDetect(G);
        System.out.println(cycleDetect.hasCycle());
    }

}
