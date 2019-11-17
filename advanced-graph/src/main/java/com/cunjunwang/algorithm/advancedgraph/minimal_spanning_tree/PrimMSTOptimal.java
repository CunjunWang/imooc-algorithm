package com.cunjunwang.algorithm.advancedgraph.minimal_spanning_tree;

import com.cunjunwang.algorithm.advancedgraph.WeightedGraph;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * Created by CunjunWang on 2019-11-17.
 */
public class PrimMSTOptimal {

    private WeightedGraph G;

    private ArrayList<WeightedEdge> mst;

    /*
     * 使用优先队列优化
     * 快速找到当前考虑的所有边中，最小的横切边
     *
     * O(E*logE)
     */
    public PrimMSTOptimal(WeightedGraph G) {

        this.G = G;
        mst = new ArrayList<>();

        ConnectedComponent cc = new ConnectedComponent(G);
        if (cc.getConnectedComponentCount() > 1)
            return;

        // Optimized Prim
        boolean[] visited = new boolean[G.V()];
        visited[0] = true;
        PriorityQueue<WeightedEdge> pq = new PriorityQueue<>();

        for (int w : G.adj(0))
            pq.add(new WeightedEdge(0, w, G.getWeight(0, w)));

        while (!pq.isEmpty()) {

            WeightedEdge minEdge = pq.poll();
            if (visited[minEdge.getV()] && visited[minEdge.getW()])
                continue;

            mst.add(minEdge);

            // 扩展切分
            int newV = visited[minEdge.getV()] ?
                    minEdge.getV() : minEdge.getW();

            for (int w : G.adj(newV))
                if (!visited[w])
                    pq.add(new WeightedEdge(newV, w, G.getWeight(newV, w)));
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
