//
// Created by 王存俊 on 2019-07-14.
//

// Kruskal 算法生成 MST
// Greedy Algorithm
// 用Union Find作为辅助结构判断两个node是否已经相连
// O(E*log(E))

#ifndef WEIGHTED_GRAPH_KRUSKALMST_H
#define WEIGHTED_GRAPH_KRUSKALMST_H

#include <iostream>
#include <vector>
#include "MinHeap.h"
#include "UnionFind.h"
#include "Edge.h"


using namespace std;

template<typename Graph, typename Weight>
class KruskalMST {

private:
    vector<Edge<Weight>> mst;
    Weight mstWeight;

public:
    KruskalMST(Graph &graph) {
        MinHeap<Edge<Weight>> priorityQueue(graph.E());
        for (int i = 0; i < graph.V(); i++) {
            typename Graph::adjacentIterator adj(graph, i);
            for (Edge<Weight> *e = adj.begin(); !adj.end(); e = adj.next()) {
                if (e->v() < e->w()) {
                    priorityQueue.insert(*e);
                }

            }
        }

        UnionFind unionFind(graph.V());

        while (!priorityQueue.isEmpty() && mst.size() < graph.V() - 1) {
            Edge<Weight> e = priorityQueue.extractMin();
            if (unionFind.isConnected(e.v(), e.w())) {
                continue;
            }
            mst.push_back(e);
            unionFind.unionElements(e.v(), e.w());
        }

        mstWeight = mst[0].getWeight();
        for (int i = 1; i < mst.size(); i++) {
            mstWeight += mst[i].getWeight();
        }
    }

    ~KruskalMST() {

    }

    vector<Edge<Weight>> mstEdges() {
        return mst;
    }

    Weight result() {
        return mstWeight;
    }
};


#endif //WEIGHTED_GRAPH_KRUSKALMST_H
