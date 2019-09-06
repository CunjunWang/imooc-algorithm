package com.cunjunwang.algorithm.advancedgraph.bfs.connected_component;

import com.cunjunwang.algorithm.advancedgraph.Graph;
import com.cunjunwang.algorithm.advancedgraph.dfs.connected_component.ConnectedComponent;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 使用bfs求联通分量个数
 * Created by CunjunWang on 2019-09-05.
 */
public class ConnectedComponentBFS {

    private Graph G;

    private boolean[] visited;

    private int connectedComponentCount;

    public ConnectedComponentBFS(Graph G) {
        this.G = G;
        visited = new boolean[G.V()];
        connectedComponentCount = 0;
        for (int v = 0; v < G.V(); v++)
            if (!visited[v]) {
                bfs(v);
                connectedComponentCount++;
            }
    }

    /**
     * 通过bfs获得联通分量个数
     *
     * @param v 起始节点
     */
    private void bfs(int v) {
        Queue<Integer> todo = new LinkedList<>();
        todo.add(v);
        visited[v] = true;
        while (!todo.isEmpty()) {
            Integer cur = todo.remove();
            for (int w : G.adj(cur)) {
                if (!visited[w]) {
                    todo.add(w);
                    visited[w] = true;
                }
            }
        }
    }

    /**
     * 获得联通分量个数
     *
     * @return 联通分量个数
     */
    public int getConnectedComponentCount() {
        return connectedComponentCount;
    }

    public static void main(String[] args) {
        String filename = "./src/main/java/com/cunjunwang/algorithm/advancedgraph/g.txt";
        Graph G = new Graph(filename);
        ConnectedComponentBFS cc = new ConnectedComponentBFS(G);
        System.out.println(cc.getConnectedComponentCount());
    }

}
