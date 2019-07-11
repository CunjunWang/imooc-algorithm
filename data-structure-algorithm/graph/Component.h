//
// Created by 王存俊 on 2019-07-11.
//

// 通过DFS求出connect component

#ifndef GRAPH_COMPONENT_H
#define GRAPH_COMPONENT_H

#include <iostream>
#include <cassert>

using namespace std;

template<typename Graph>
class Component {

private:
    Graph &G;
    bool *visited;
    int componentCount;
    int *id;

    void DFS(int v) {
        visited[v] = true;
        id[v] = componentCount;
        typename Graph::adjacentIterator adj(G, v);
        for (int i = adj.begin(); !adj.end(); i = adj.next()) {
            if (!visited[i]) {
                DFS(i);
            }
        }
    }

public:
    Component(Graph &graph) : G(graph) {
        visited = new bool[G.V()];
        id = new int[G.V()];
        componentCount = 0;
        for (int i = 0; i < G.V(); i++) {
            visited[i] = false;
            id[i] = -1;
        }

        for (int i = 0; i < G.V(); i++) {
            if (!visited[i]) {
                DFS(i);
                componentCount++;
            }
        }
    }

    ~Component() {
        delete[] visited;
        delete[] id;
    }

    int count() {
        return componentCount;
    }

    bool isConnected(int v, int w) {
        assert(v >= 0 && v < G.V());
        assert(w >= 0 && w < G.V());
        return id[v] == id[w];
    }

};

#endif //GRAPH_COMPONENT_H
