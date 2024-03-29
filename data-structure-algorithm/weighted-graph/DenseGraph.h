//
// Created by 王存俊 on 2019-07-13.
//

// 稠密加权图

#ifndef WEIGHTED_GRAPH_DENSEGRAPH_H
#define WEIGHTED_GRAPH_DENSEGRAPH_H

#include <iostream>
#include <vector>
#include <cassert>
#include "Edge.h"

using namespace std;

template<typename Weight>
class DenseGraph {

private:
    int n, m;
    bool directed;
    vector<vector<Edge<Weight> *>> g;

public:
    DenseGraph(int n, bool directed) {
        this->n = n;
        this->m = 0;
        this->directed = directed;
        for (int i = 0; i < n; i++) {
            g.push_back(vector<Edge<Weight> *>(n, NULL));
        }
    }

    ~DenseGraph() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (g[i][j] != NULL) {
                    delete g[i][j];
                }
            }
        }
    }

    int V() { return n; }

    int E() { return m; }

    // 在v和w节点之间添加一条边
    void addEdge(int v, int w, Weight weight) {
        assert(v >= 0 && v < n);
        assert(w >= 0 && w < n);

        if (hasEdge(v, w)) {
            delete g[v][w];
            if (!directed) {
                delete g[w][v];
            }
            m--;
        }

        g[v][w] = new Edge<Weight>(v, w, weight);
        if (!directed) {
            g[w][v] = new Edge<Weight>(w, v, weight);
        }
        m++;
    }

    // 判断两个节点之间有没有边相连
    bool hasEdge(int v, int w) {
        assert(v >= 0 && v < n);
        assert(w >= 0 && w < n);
        return g[v][w] != NULL;
    }

    void show() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (g[i][j]) {
                    cout << g[i][j]->getWeight() << "\t";
                } else {
                    cout << "NULL\t";
                }
            }
            cout << endl;
        }
    }

    class adjacentIterator {

    private:
        DenseGraph &G; // 图
        int v; // 节点
        int index; // 当前迭代位置

    public:
        adjacentIterator(DenseGraph &graph, int v) : G(graph) {
            this->v = v;
            this->index = 0;
        }

        Edge<Weight> *begin() {
            index = -1;
            return next();
        }

        Edge<Weight> *next() {
            for (index += 1; index < G.V(); index++) {
                if (G.g[v][index]) {
                    return G.g[v][index];
                } else {
                    return NULL;
                };
            }
            return -1;
        }

        bool end() {
            return index >= G.V();
        }

    };

};

#endif //WEIGHTED_GRAPH_DENSEGRAPH_H
