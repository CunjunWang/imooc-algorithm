package com.cunjunwang.algorithm.advancedgraph.bfs.undirected_graph_cycle_detect;

import com.cunjunwang.algorithm.advancedgraph.Graph;
import com.cunjunwang.algorithm.advancedgraph.dfs.undirected_graph_cycle_detection.UndirectedGraphCycleDetect;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 无向图环检测, 基于bfs
 * Created by CunjunWang on 2019-09-05.
 */
public class UndirectedGraphCycleDetectBFS {

    private Graph G;

    private boolean[] visited;

    private int[] pre;

    private boolean hasCycle;

    public UndirectedGraphCycleDetectBFS(Graph G) {
        this.G = G;
        this.hasCycle = false;
        this.pre = new int[G.V()];
        this.visited = new boolean[G.V()];
        for (int i = 0; i < pre.length; i++) {
            pre[i] = -1;
        }
        for (int v = 0; v < G.V(); v++)
            if (!visited[v] && bfs(v)) {
                hasCycle = true;
                break;
            }
    }

    /**
     * 对Graph进行广度优先遍历, 检测是否有环
     * O(V + E)
     *
     * @param v      当前节点
     * @return 从v开始遍历, 是否有环
     */
    private boolean bfs(int v) {
        Queue<Integer> todo = new LinkedList<>();
        todo.add(v);
        visited[v] = true;
        pre[v] = v;
        while (!todo.isEmpty()) {
            int cur = todo.remove();
            for (int w : G.adj(cur)) {
                if (!visited[w]) {
                    todo.add(w);
                    visited[w] = true;
                    pre[w] = cur;
                } else if (pre[w] != cur) {
                    // 当前w访问过, 而且不是cur的上一个节点, 那么就找到环了
                    return true;
                }
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
