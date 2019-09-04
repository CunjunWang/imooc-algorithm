package com.cunjunwang.algorithm.advancedgraph.dfs;

import com.cunjunwang.algorithm.advancedgraph.Graph;

import java.util.ArrayList;

/**
 * Created by CunjunWang on 2019-09-03.
 */
public class GraphDFS {

    private Graph G;

    private boolean[] visited;

    // dfs之后的结果
    private ArrayList<Integer> order = new ArrayList<>();

    public GraphDFS(Graph G) {
        this.G = G;
        visited = new boolean[G.V()];
        for (int v = 0; v < G.V(); v++)
            if (!visited[v])
                dfs(v);
    }

    /**
     * 对Graph进行深度优先遍历
     * 递归写法
     *
     * @param v
     */
    private void dfs(int v) {
        visited[v] = true;
        order.add(v);
        for (int w : G.adj(v))
            if (!visited[w])
                dfs(w);
    }

    /**
     * 获得遍历结果
     *
     * @return order 遍历结果
     */
    public Iterable<Integer> getOrder() {
        return order;
    }

    public static void main(String[] args) {
        String filename = "./src/main/java/com/cunjunwang/algorithm/advancedgraph/g.txt";
        Graph G = new Graph(filename);
        GraphDFS graphDFS = new GraphDFS(G);
        System.out.println(graphDFS.getOrder());
    }

}
