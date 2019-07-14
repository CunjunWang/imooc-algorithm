//
// Created by 王存俊 on 2019-07-14.
//

// Lazy Prim算法找到最小生成树

#ifndef WEIGHTED_GRAPH_LAZYPRIMMST_H
#define WEIGHTED_GRAPH_LAZYPRIMMST_H

#include <vector>
#include "Edge.h"
#include "MinHeap.h"

using namespace std;

template<typename Graph, typename Weight>
class LazyPrimMST {

private:
    Graph &G;
    MinHeap<Edge<Weight>> priorityQueue;
    bool *marked; // 节点是否被切分
    vector<Edge<Weight>> mst;
    Weight mstWeight;

    void visit(int v) {
        assert(!marked[v]);
        marked[v] = true;

        typename Graph::adjacentIterator adj(G, v);
        for (Edge<Weight> *e = adj.begin(); !adj.end(); e = adj.next()) {
            if (!marked[e->other(v)]) {
                priorityQueue.insert(*e);
            }
        }
    }

public:
    LazyPrimMST(Graph &graph) : G(graph), priorityQueue(MinHeap<Edge<Weight>>(graph.E())) {
        marked = new bool[G.V()];
        for (int i = 0; i < G.V(); i++) {
            marked[i] = false;
        }
        mst.clear();

        // Lazy Prim
        // O(E*lg(E))
        visit(0);
        while (!priorityQueue.isEmpty()) { // 执行E次
            Edge<Weight> e = priorityQueue.extractMin(); // O(lg(E))
            if (marked[e.v()] == marked[e.w()]) {
                // 若边的两个端点的颜色相同，不是横切边，跳过
                continue;
            }
            // 如果是横切边，根据切分定理 cut property, 该边一定在mst中
            mst.push_back(e);

            if (!marked[e.v()]) {
                visit(e.v()); // O(lg(E))
            } else {
                visit(e.w());
            }
        }

        // 计算最小权值
        mstWeight = mst[0].getWeight();
        for (int i = 1; i < mst.size(); i++) {
            mstWeight += mst[i].getWeight();
        }
    }

    ~LazyPrimMST() {
        delete[] marked;
    }

    vector<Edge<Weight>> mstEdges() {
        return mst;
    }

    Weight result() {
        return mstWeight;
    }

};

#endif //WEIGHTED_GRAPH_LAZYPRIMMST_H
