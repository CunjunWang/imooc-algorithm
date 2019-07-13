//
// Created by 王存俊 on 2019-07-13.
//

// 最短路径
// 通过BFS求出最短路径

// BFS实现：
// 稀疏图：邻接表，O(V+E)
// 稠密图：邻接矩阵，O(V^2)

#ifndef GRAPH_SHORTESTPATH_H
#define GRAPH_SHORTESTPATH_H

#include <queue>
#include <cassert>

template<typename Graph>
class ShortestPath {

private:
    Graph &G;
    int s;
    bool *visited;
    int *from;
    int *ord; // 从s到该节点的最短距离是多少

public:
    ShortestPath(Graph &graph, int s) : G(graph) {

        // 初始化
        assert(s >= 0 && s < graph.V());

        visited = new bool[graph.V()];
        from = new int[graph.V()];
        ord = new int[graph.V()];
        for (int i = 0; i < graph.V(); i++) {
            visited[i] = false;
            from[i] = -1;
            ord[i] = -1;
        }
        this->s = s;

        queue<int> q;

        // 无向图的最短路径算法
        q.push(s);
        visited[s] = true;
        ord[s] = 0;
        while (!q.empty()) {
            int v = q.front();
            q.pop();

            typename Graph::adjacentIterator adj(G, v);
            for (int i = adj.begin(); !adj.end(); adj.next()) {
                if (!visited[i]) {
                    q.push(i);
                    visited[i] = true;
                    from[i] = v;
                    ord[i] = ord[v] + 1;
                }
            }

        }

    }

    ~ShortestPath() {
        delete[] visited;
        delete[] from;
        delete[] ord;
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

    int length(int w) {
        assert(w >= 0 && w < G.V());
        return ord[w];
    }

};

#endif //GRAPH_SHORTESTPATH_H
