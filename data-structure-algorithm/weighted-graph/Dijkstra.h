//
// Created by 王存俊 on 2019-07-16.
//

// 前提条件: 不能有weight < 0
// 复杂度: O(E*log(V))
// 借助IndexMinHeap作为中转数据结构

#ifndef WEIGHTED_GRAPH_DIJKSTRA_H
#define WEIGHTED_GRAPH_DIJKSTRA_H

#include <iostream>
#include <vector>
#include <stack>
#include "Edge.h"
#include "IndexMinHeap.h"

using namespace std;

template<typename Graph, typename Weight>
class Dijkstra {

private:
    Graph &G;
    int s;
    Weight *distTo;
    bool *marked;
    vector<Edge<Weight> *> from;

public:
    Dijkstra(Graph &graph, int s) : G(graph) {
        this->s = s;
        distTo = new Weight[G.V()];
        marked = new bool[G.V()];
        for (int i = 0; i < G.V(); i++) {
            distTo[i] = Weight();
            marked[i] = false;
            from.push_back(NULL);
        }

        IndexMinHeap<Weight> indexPriorityQueue(G.V());

        // Dijkstra
        distTo[s] = Weight();
        marked[s] = true;
        indexPriorityQueue.insert(s, distTo[s]);
        while (!indexPriorityQueue.isEmpty()) {
            int v = indexPriorityQueue.extractMinIndex();
            // distTo[v] 就是s到v的最短距离
            marked[v] = true;

            typename Graph::adjacentIterator adj(G, v);
            for (Edge<Weight> *e = adj.begin(); !adj.end(); e = adj.next()) {
                int w = e->other(v);
                if (!marked[w]) {
                    // Relaxation
                    if (from[w] == NULL || distTo[v] + e->getWeight() < distTo[w]) {
                        distTo[w] = distTo[v] + e->getWeight();
                        from[w] = e;
                        if (indexPriorityQueue.contain(w)) {
                            indexPriorityQueue.change(w, distTo[w]);
                        } else {
                            indexPriorityQueue.insert(w, distTo[w]);
                        }
                    }
                }
            }
        }

    }

    ~Dijkstra() {
        delete[] distTo;
        delete[] marked;
        delete from[0];
    }

    Weight shortestPathTo(int w) {
        assert(w >= 0 && w < G.V());
        assert(hasPathTo(w));
        return distTo[w];
    }

    bool hasPathTo(int w) {
        assert(w >= 0 && w < G.V());
        return marked[w];
    }

    void shortestPath(int w, vector<Edge<Weight>> &vec) {

        assert(w >= 0 && w < G.V());
        assert(hasPathTo(w));

        stack<Edge<Weight> *> s;
        Edge<Weight> *e = from[w];
        while (e->v() != this->s) {
            s.push(e);
            e = from[e->v()];
        }
        s.push(e);
        while (!s.empty()) {
            e = s.top();
            vec.push_back(*e);
            s.pop();
        }
    }

    void showPath(int w) {
        assert(w >= 0 && w < G.V());
        assert(hasPathTo(w));

        vector<Edge<Weight>> vec;
        shortestPath(w, vec);
        for (int i = 0; i < vec.size(); i++) {
            cout << vec[i].v() << " -> ";
            if (i == vec.size() - 1) {
                cout << vec[i].w() << endl;
            }
        }
    }

};

#endif //WEIGHTED_GRAPH_DIJKSTRA_H
