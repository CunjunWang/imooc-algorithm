package com.cunjunwang.algorithm.advancedgraph.dfs;

import com.cunjunwang.algorithm.advancedgraph.Graph;

import java.util.Stack;

/**
 * Created by CunjunWang on 2019-09-04.
 */
public class SolveConnectedComponent {

    private Graph G;

    private int[] visited;

    private int connectedComponentCount;

    public SolveConnectedComponent(Graph G) {
        this.G = G;
        visited = new int[G.V()];
        connectedComponentCount = 0;
        for (int i = 0; i < visited.length; i++)
            visited[i] = -1;
        for (int v = 0; v < G.V(); v++)
            if (visited[v] == -1) {
                dfs(v, connectedComponentCount);
                connectedComponentCount++;
            }
    }

    /**
     * 对Graph进行深度优先遍历
     * 递归写法
     * <p>
     * O(V + E)
     *
     * @param v           顶点
     * @param componentId 联通分量Id
     */
    private void dfs(int v, int componentId) {
        visited[v] = componentId;
        for (int w : G.adj(v))
            if (visited[w] == -1)
                dfs(w, componentId);
    }

    /**
     * 对Graph进行深度优先遍历
     * 迭代写法
     *
     * @param v           顶点
     * @param componentId 联通分量Id
     */
    private void dfsIterative(int v, int componentId) {
        Stack<Integer> todo = new Stack<>();
        todo.push(v);
        visited[v] = componentId;
        while (!todo.empty()) {
            Integer cur = todo.pop();
            for (int w : G.adj(cur)) {
                if (visited[w] == -1) {
                    todo.push(w);
                    visited[w] = componentId;
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
        for (int e : visited) {
            System.out.print(e + " ");
        }
        System.out.println();
        return connectedComponentCount;
    }

    public static void main(String[] args) {
        String filename = "./src/main/java/com/cunjunwang/algorithm/advancedgraph/g1.txt";
        Graph G = new Graph(filename);
        SolveConnectedComponent cc = new SolveConnectedComponent(G);
        System.out.println(cc.getConnectedComponentCount());
    }

}
