//
// Created by 王存俊 on 2019-07-13.
//

// 加权图的边

#ifndef WEIGHTED_GRAPH_EDGE_H
#define WEIGHTED_GRAPH_EDGE_H

#include <iostream>

using namespace std;

template<typename Weight>
class Edge {

private:
    int a, b;
    Weight weight;

public:
    Edge(int a, int b, Weight weight) {
        this->a = a;
        this->b = b;
        this->weight = weight;
    }

    Edge() {}

    ~Edge() {}

    int v() { return a; }

    int w() { return b; }

    Weight getWeight() { return weight; }

    int other(int x) {
        assert (x == a || x == b);
        return x == a ? b : a;
    }

    friend ostream &operator<<(ostream &os, const Edge &e) {
        os << e.a << "-" << e.b << ": " << e.weight;
        return os;
    }

    bool operator<(Edge<Weight> &e) {
        return weight < e.getWeight();
    }

    bool operator<=(Edge<Weight> &e) {
        return weight <= e.getWeight();
    }

    bool operator>(Edge<Weight> &e) {
        return weight > e.getWeight();
    }

    bool operator>=(Edge<Weight> &e) {
        return weight >= e.getWeight();
    }

    bool operator==(Edge<Weight> &e) {
        return weight == e.getWeight();
    }

};

#endif //WEIGHTED_GRAPH_EDGE_H
