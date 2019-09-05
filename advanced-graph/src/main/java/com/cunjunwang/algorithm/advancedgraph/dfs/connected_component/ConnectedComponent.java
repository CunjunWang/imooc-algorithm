package com.cunjunwang.algorithm.advancedgraph.dfs.connected_component;

import com.cunjunwang.algorithm.advancedgraph.Graph;

import java.util.Stack;

/**
 * 使用dfs求联通分量个数
 * Created by CunjunWang on 2019-09-04.
 */
public class ConnectedComponent {

    private Graph G;

    private boolean[] visited;

    private int connectedComponentCount;

    public ConnectedComponent(Graph G) {
        this.G = G;
        visited = new boolean[G.V()];
        connectedComponentCount = 0;
        for (int v = 0; v < G.V(); v++)
            if (!visited[v]) {
                dfs(v);
                connectedComponentCount++;
            }
    }

    /**
     * 对Graph进行深度优先遍历
     * 递归写法
     *
     * O(V + E)
     *
     * @param v
     */
    private void dfs(int v) {
        visited[v] = true;
        for (int w : G.adj(v))
            if (!visited[w])
                dfs(w);
    }

    private void dfsIterative(int v) {
        Stack<Integer> todo = new Stack<>();
        todo.push(v);
        visited[v] = true;
        while (!todo.empty()) {
            Integer cur = todo.pop();
            for (int w : G.adj(cur)) {
                if (!visited[w]) {
                    todo.push(w);
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
        ConnectedComponent cc = new ConnectedComponent(G);
        System.out.println(cc.getConnectedComponentCount());
    }
}
