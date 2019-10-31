package com.cunjunwang.algorithm.advancedgraph.minimal_spanning_tree;

import com.cunjunwang.algorithm.advancedgraph.WeightedGraph;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by CunjunWang on 2019-10-30.
 */
public class KruskalMST {

    private WeightedGraph G;

    private ArrayList<WeightedEdge> mst;

    public KruskalMST(WeightedGraph G) {
        this.G = G;
        mst = new ArrayList<>();

        ConnectedComponent cc = new ConnectedComponent(G);

        if (cc.getConnectedComponentCount() > 1)
            return;

        // Kruskal
        ArrayList<WeightedEdge> edges = new ArrayList<>();
        for (int v = 0; v < G.V(); v++) {
            for (int w : G.adj(v)) {
                // 去重
                if (v < w) {
                    edges.add(new WeightedEdge(v, w, G.getWeight(v, w)));
                }
            }
        }
        // 所有边按照权值从小到大排序
        Collections.sort(edges);

        // 并查集快速判断是否有环
        UnionFind uf = new UnionFind(G.V());

        for (WeightedEdge edge : edges) {
            int v = edge.getV();
            int w = edge.getW();
            // 使用并查集动态调整连通性
            if (!uf.isConnected(v, w)) {
                mst.add(edge);
                uf.unionElements(v, w);
            }

            if (mst.size() == G.V() - 1) {
                break;
            }
        }
    }

    public ArrayList<WeightedEdge> result() {
        return mst;
    }

    public static void main(String[] args) {
        WeightedGraph g = new WeightedGraph("./src/main/java/com/cunjunwang/algorithm/advancedgraph/g.txt");
        KruskalMST kruskalMST = new KruskalMST(g);
        ArrayList<WeightedEdge> result = kruskalMST.result();
        System.out.println(result);
    }
}
