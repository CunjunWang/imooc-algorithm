//
// Created by 王存俊 on 2019-07-16.
//

// 图中可以由负权边, 但是不能有负权环
// 如果图中有负权环, Bellman-Ford可以判断出来

// 如果一个图有负权环, 那么没有最短路径, 因为可以在这个环中不停地绕下去

// O(EV)

#ifndef WEIGHTED_GRAPH_BELLMANFORD_H
#define WEIGHTED_GRAPH_BELLMANFORD_H

#include <cassert>
#include <stack>
#include <vector>
#include "Edge.h"

template<typename Graph, typename Weight>
class BellmanFord {

private:
    Graph &G;
    int s;
    Weight *distTo;
    vector<Edge<Weight> *> from;
    bool hasNegativeCycle;

    // 最后再做一轮Relaxation
    bool detectNegativeCycle() {
        for (int i = 0; i < G.V(); i++) {
            typename Graph::adjacentIterator adj(G, i);
            for (Edge<Weight> *e = adj.begin(); !adj.end(); e = adj.next()) {
                if (!from[e->w()] || distTo[e->v()] + e->getWeight() < distTo[e->w()]) {
                    return true;
                }
            }
        }
        return false;
    }

public:
    BellmanFord(Graph &graph, int s) : G(graph) {
        this->s = s;
        distTo = new Weight[G.V()];
        for (int i = 0; i < G.V(); i++) {
            from.push_back(NULL);
        }

        // Bellman-Ford
        distTo[s] = Weight();
        // 对所有节点进行 V-1 轮松弛操作
        for (int pass = 1; pass < G.V(); pass++) {
            // Relaxation
            for (int i = 0; i < G.V(); i++) {
                typename Graph::adjacentIterator adj(G, i);
                for (Edge<Weight> *e = adj.begin(); !adj.end(); e = adj.next()) {
                    if (!from[e->w()] || distTo[e->v()] + e->getWeight() < distTo[e->w()]) {
                        distTo[e->w()] = distTo[e->v()] + e->getWeight();
                        from[e->w()] = e;
                    }
                }
            }
        }

        hasNegativeCycle = detectNegativeCycle();

    }

    ~BellmanFord() {
        delete[] distTo;
    }

    bool negativeCycle() {
        return hasNegativeCycle;
    }

    Weight shortestPathTo(int w) {
        assert(w >= 0 && w < G.V());
        assert(!hasNegativeCycle);
        return distTo[w];
    }

    bool hasPathTo(int w) {
        assert(w >= 0 && w < G.V());
        return from[w] != NULL;
    }

    void shortestPath(int w, vector<Edge<Weight>> &vec) {
        assert(w >= 0 && w < G.V());
        assert(!hasNegativeCycle);

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
        assert(!hasNegativeCycle);

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

#endif //WEIGHTED_GRAPH_BELLMANFORD_H
