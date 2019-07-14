//
// Created by 王存俊 on 2019-07-14.
//

// 优化后的Prim算法, 寻找最小生成树

// O(E*log(V))

#ifndef WEIGHTED_GRAPH_PRIMMST_H
#define WEIGHTED_GRAPH_PRIMMST_H

#include <iostream>
#include <vector>
#include <cassert>
#include "Edge.h"
#include "IndexMinHeap.h"

using namespace std;

template<typename Graph, typename Weight>
class PrimMST {

private:
    Graph &G;
    IndexMinHeap<Weight> indexPriorityQueue;
    vector<Edge<Weight> *> edgeTo;
    bool *marked;
    vector<Edge<Weight>> mst;
    Weight mstWeight;

    void visit(int v) {
        assert(!marked[v]);
        marked[v] = true;

        typename Graph::adjacentIterator adj(G, v);
        for (Edge<Weight> *e = adj.begin(); !adj.end(); e = adj.next()) {
            int w = e->other(v);
            if (!marked[w]) {
                if (!edgeTo[w]) {
                    indexPriorityQueue.insert(w, e->getWeight());
                    edgeTo[w] = e;
                } else if (e->getWeight() < edgeTo[w]->getWeight()) {
                    edgeTo[w] = e;
                    indexPriorityQueue.change(w, e->getWeight());
                }
            }
        }
    }

public:
    PrimMST(Graph &graph) : G(graph), indexPriorityQueue(IndexMinHeap<double>(graph.V())) {
        marked = new bool[G.V()];
        for (int i = 0; i < G.V(); i++) {
            marked[i] = false;
            edgeTo.push_back(NULL);
        }
        mst.clear();

        // Prim
        visit(0);
        while (!indexPriorityQueue.isEmpty()) {
            int v = indexPriorityQueue.extractMinIndex();
            assert(edgeTo[v]);
            mst.push_back(*edgeTo[v]);
            visit(v);
        }

        // 计算最小权值
        mstWeight = mst[0].getWeight();
        for (int i = 1; i < mst.size(); i++) {
            mstWeight += mst[i].getWeight();
        }
    }

    ~PrimMST() {
        delete[] marked;
    }

    vector<Edge<Weight>> mstEdges() {
        return mst;
    }

    Weight result() {
        return mstWeight;
    }

};

#endif //WEIGHTED_GRAPH_PRIMMST_H
