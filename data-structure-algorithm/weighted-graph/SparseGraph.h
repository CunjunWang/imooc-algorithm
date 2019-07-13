//
// Created by 王存俊 on 2019-07-13.
//

// 稀疏加权图

#ifndef WEIGHTED_GRAPH_SPARSEGRAPH_H
#define WEIGHTED_GRAPH_SPARSEGRAPH_H

#include <iostream>
#include <vector>
#include <cassert>
#include "Edge.h"

using namespace std;

template<typename Weight>
class SparseGraph {

private:
    int n, m;
    bool directed;
    vector<vector<Edge<Weight> *>> g;

public:
    SparseGraph(int n, bool directed) {
        this->n = n;
        this->m = 0;
        this->directed = directed;
        for (int i = 0; i < n; i++) {
            g.push_back(vector<Edge<Weight> *>());
        }
    }

    ~SparseGraph() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < g[i].size(); j++) {
                delete g[i][j];
            }
        }
    }

    int V() { return n; }

    int E() { return m; }

    void addEdge(int v, int w, Weight weight) {
        assert(v >= 0 && v < n);
        assert(v >= 0 && w < n);

        g[v].push_back(new Edge<Weight>(v, w, weight));
        // 考虑自环边
        if (v != w && !directed) {
            g[w].push_back(new Edge<Weight>(w, v, weight));
        }

        // 由于平行边的判定为O(n), 暂时不考虑

        m++;
    }

    bool hasEdge(int v, int w) {
        assert(v >= 0 && v < n);
        assert(v >= 0 && w < n);

        for (int i = 0; i < g[v].size(); i++) {
            if (g[v][i]->other(v) == w) {
                return true;
            }
        }
        return false;
    }

    void show() {
        for (int i = 0; i < n; i++) {
            cout << "vertex " << i << ":\t";
            for (int j = 0; j < g[i].size(); j++) {
                cout << " to: " << g[i][j]->w() << ", weight: " << g[i][j]->getWeight() << "\t";
            }
            cout << endl;
        }
    }

    class adjacentIterator {

    private:
        SparseGraph &G; // 图
        int v; // 节点
        int index; // 当前迭代位置

    public:
        adjacentIterator(SparseGraph &graph, int v) : G(graph) {
            this->v = v;
            this->index = 0;
        }

        Edge<Weight> *begin() {
            index = 0;
            if (G.g[v].size()) {
                return G.g[v][index];
            }
            return NULL;
        }

        Edge<Weight> *next() {
            index++;
            if (index < G.g[v].size()) {
                return G.g[v][index];
            }
            return NULL;
        }

        bool end() {
            return index >= G.g[v].size();
        }

    };

};

#endif //WEIGHTED_GRAPH_SPARSEGRAPH_H
