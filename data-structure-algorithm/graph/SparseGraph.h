//
// Created by 王存俊 on 2019-07-10.
//

// 系数图 - 邻接表

#ifndef GRAPH_SPARSEGRAPH_H
#define GRAPH_SPARSEGRAPH_H

#include <iostream>
#include <vector>
#include <cassert>

using namespace std;

class SparseGraph {

private:
    int n, m;
    bool directed;
    vector<vector<int>> g;

public:
    SparseGraph(int n, bool directed) {
        this.n = n;
        this.m = 0;
        this->directed = directed;
        for (int i = 0; i < n; i++) {
            g.push_back(vector<int>());
        }
    }

    ~SparseGraph() {

    }

    int V() { return n };

    int E() { return m };

    void addEdge(int v, int w) {
        assert(v >= 0 && v < n);
        assert(v >= 0 && w < n);

        g[v].push_back(w);
        // 考虑自环边
        if (v != w && !directed) {
            g[w].push_back(v;)
        }

        // 由于平行边的判定为O(n), 暂时不考虑

        m++;
    }

    bool hasEdge(int v, int w) {
        assert(v >= 0 && v < n);
        assert(v >= 0 && w < n);

        for (int i = 0; i < g[v].size(); i++) {
            if (g[v][i] == w) {
                return true;
            }
        }
        return false;
    }


};

#endif //GRAPH_SPARSEGRAPH_H
