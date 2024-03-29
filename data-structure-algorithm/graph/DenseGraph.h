//
// Created by 王存俊 on 2019-07-10.
//

// 稠密图 - 邻接矩阵

#ifndef GRAPH_DENSEGRAPH_H
#define GRAPH_DENSEGRAPH_H

#include <iostream>
#include <vector>
#include <cassert>

using namespace std;

class DenseGraph {

private:
    int n, m;
    bool directed;
    vector<vector<bool>> g;

public:
    DenseGraph(int n, bool directed) {
        this->n = n;
        this->m = 0;
        this->directed = directed;
        for (int i = 0; i < n; i++) {
            g.push_back(vector<bool>(n, false));
        }
    }

    ~DenseGraph() {

    }

    int V() { return n; }

    int E() { return m; }

    // 在v和w节点之间添加一条边
    void addEdge(int v, int w) {
        assert(v >= 0 && v < n);
        assert(w >= 0 && w < n);

        if (hasEdge(v, w)) {
            return;
        }
        g[v][w] = true;

        if (!directed) {
            g[w][v] = true;
        }

        m++;
    }

    // 判断两个节点之间有没有边相连
    bool hasEdge(int v, int w) {
        assert(v >= 0 && v < n);
        assert(w >= 0 && w < n);
        return g[v][w];
    }

    void show() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cout << g[i][j] << "\t";
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

        int begin() {
            index = -1;
            return next();
        }

        int next() {
            for (index += 1; index < G.V(); index++) {
                if (G.g[v][index]) {
                    return index;
                }
            }
            return -1;
        }

        bool end() {
            return index >= G.V();
        }

    };


};

#endif //GRAPH_DENSEGRAPH_H
