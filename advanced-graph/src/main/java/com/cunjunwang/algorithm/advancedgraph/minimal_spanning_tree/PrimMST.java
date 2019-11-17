package com.cunjunwang.algorithm.advancedgraph.minimal_spanning_tree;

import com.cunjunwang.algorithm.advancedgraph.WeightedGraph;

import java.util.ArrayList;

/**
 * Created by CunjunWang on 2019-11-17.
 */
public class PrimMST {

    private WeightedGraph G;

    private ArrayList<WeightedEdge> mst;

    /*
     * O((V-1)*(V+E)) = O(VE)
     */
    public PrimMST(WeightedGraph G) {

        this.G = G;
        mst = new ArrayList<>();

        ConnectedComponent cc = new ConnectedComponent(G);
        if (cc.getConnectedComponentCount() > 1)
            return;

        // Prim

        // 表示切分
        boolean[] visited = new boolean[G.V()];
        visited[0] = true;

        // 找最小的横切边
        for (int i = 1; i < G.V(); i++) {
            WeightedEdge minEdge = new WeightedEdge(-1, -1, Integer.MAX_VALUE);
            for (int v = 0; v < G.V(); v++)
                if (visited[v])
                    for (int w : G.adj(v))
                        if (!visited[w] && G.getWeight(v, w) < minEdge.getWeight())
                            minEdge = new WeightedEdge(v, w, G.getWeight(v, w));

            // 添加结果
            mst.add(minEdge);

            // 扩充切分
            visited[minEdge.getV()] = true;
            visited[minEdge.getW()] = true;
        }

    }

    public ArrayList<WeightedEdge> getResult() {
        return mst;
    }

    public static void main(String[] args) {
        WeightedGraph g = new WeightedGraph("./src/main/java/com/cunjunwang/algorithm/advancedgraph/test_graph/g.txt");
        PrimMST primMST = new PrimMST(g);
        System.out.println(primMST.getResult());
    }
}
