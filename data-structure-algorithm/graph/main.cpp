#include <iostream>
#include "SparseGraph.h"
#include "DenseGraph.h"

using namespace std;

int main() {
    int N = 20;
    int M = 100;

    srand(time(NULL));

    // Sparse Graph
    SparseGraph g1(N, false);
    for (int i = 0; i < M; i++) {
        int a = rand() % N;
        int b = rand() % N;
        g1.addEdge(a, b);
    }

    // O(E)
    for (int v = 0; v < N; v++) {
        cout << v << " : ";
        SparseGraph::adjacentIterator iterator(g1, v);
        for (int w = iterator.begin(); !iterator.end(); w = iterator.next()) {
            cout << w << " ";
        }
        cout << endl;
    }

    cout << endl;

    // Dense Graph
    DenseGraph g2(N, false);
    for (int i = 0; i < M; i++) {
        int a = rand() % N;
        int b = rand() % N;
        g2.addEdge(a, b);
    }

    // O(V^2)
    for (int v = 0; v < N; v++) {
        cout << v << " : ";
        DenseGraph::adjacentIterator iterator(g2, v);
        for (int w = iterator.begin(); !iterator.end(); w = iterator.next()) {
            cout << w << " ";
        }
        cout << endl;
    }

}