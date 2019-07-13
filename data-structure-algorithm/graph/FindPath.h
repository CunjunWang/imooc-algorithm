//
// Created by 王存俊 on 2019-07-13.
//

// 寻路算法

// DFS实现：
// 稀疏图：邻接表，O(V+E)
// 稠密图：邻接矩阵，O(V^2)

#ifndef GRAPH_FINDPATH_H
#define GRAPH_FINDPATH_H

#include <vector>
#include <cassert>
#include <stack>
#include <iostream>

template<typename Graph>
class FindPath {

private:
    Graph &G;
    int s;
    bool *visited;
    int *from;

    void DFS(int v) {
        visited[v] = true;
        typename Graph::adjacentIterator adj(G, v);
        for (int i = adj.begin(); !adj.end(); i = adj.next()) {
            if (!visited[i]) {
                from[i] = v;
                DFS(i);
            }
        }
    }

public:
    FindPath(Graph &graph, int s) : G(graph) {

        // 初始化
        assert(s >= 0 && s < G.V());

        visited = new bool[G.V()];
        from = new int[G.V()];

        for (int i = 0; i < G.V(); i++) {
            visited[i] = false;
            from[i] = -1;
        }
        this->s = s;

        // 寻路算法
        DFS(s);

    }

    ~FindPath() {
        delete[] visited;
        delete[] from;
    }

    bool hasPath(int w) {
        assert(w >= 0 && w < G.V());
        return visited[w];
    }

    void findPath(int w, vector<int> &vector) {
        stack<int> s;
        int p = w;
        while (p != -1) {
            s.push(p);
            p = from[p];
        }

        vector.clear();
        while (!s.empty()) {
            vector.push_back(s.top());
            s.pop();
        }
    }

    void showPath(int w) {
        vector<int> vec;
        findPath(w, vec);
        for (int i = 0; i < vec.size(); i++) {
            cout << vec[i];
            if (i == vec.size() - 1) {
                cout << endl;
            } else {
                cout << " -> ";
            }
        }
    }

};

#endif //GRAPH_FINDPATH_H
