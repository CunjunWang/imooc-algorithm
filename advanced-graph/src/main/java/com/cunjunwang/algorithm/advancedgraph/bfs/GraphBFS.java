package com.cunjunwang.algorithm.advancedgraph.bfs;

import com.cunjunwang.algorithm.advancedgraph.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 实现图的广度优先遍历
 * Created by CunjunWang on 2019-09-05.
 */
public class GraphBFS {

    private Graph G;

    private boolean[] visited;

    // bfs之后的结果
    private ArrayList<Integer> order = new ArrayList<>();

    public GraphBFS(Graph G) {
        this.G = G;
        visited = new boolean[G.V()];
        for (int v = 0; v < G.V(); v++) {
            if (!visited[v]) {
                bfs(v);
            }
        }
    }

    /**
     * 从顶点v开始执行广度优先搜索
     * 迭代写法
     * O(V + E)
     *
     * @param v 顶点
     */
    private void bfs(int v) {
        // bfs的队列
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        visited[v] = true;
        while (!queue.isEmpty()) {
            int cur = queue.remove();
            order.add(cur);

            for (int w : G.adj(v)) {
                if (!visited[w]) {
                    queue.add(w);
                    visited[w] = true; // 避免重复入队
                }
            }
        }
    }

    /**
     * 获得遍历结果
     *
     * @return 遍历结果
     */
    public Iterable<Integer> getOrder() {
        return order;
    }

    public static void main(String[] args) {
        String filename = "./src/main/java/com/cunjunwang/algorithm/advancedgraph/g3.txt";
        Graph G = new Graph(filename);
        GraphBFS graphBFS = new GraphBFS(G);
        System.out.println("Order: " + graphBFS.getOrder());
    }

}
