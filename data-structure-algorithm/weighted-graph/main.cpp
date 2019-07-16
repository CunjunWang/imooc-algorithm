#include <iostream>
#include <iomanip>
#include <vector>
#include "Edge.h"
#include "DenseGraph.h"
#include "SparseGraph.h"
#include "ReadGraph.h"
#include "LazyPrimMST.h"
#include "PrimMST.h"
#include "KruskalMST.h"
#include "Dijkstra.h"

using namespace std;

int main() {

// ================ test for showing weighted graph ==============

//    string fileName = "testG1.txt";
//    int V = 8;
//    cout << fixed << setprecision(2);
//
//    DenseGraph<double> g1 = DenseGraph<double>(V, false);
//    ReadGraph<DenseGraph<double>, double> readGraph1(g1, fileName);
//    g1.show();
//    cout << endl;
//
//    SparseGraph<double> g2 = SparseGraph<double>(V, false);
//    ReadGraph<SparseGraph<double>, double> readGraph2(g2, fileName);
//    g2.show();
//    cout << endl;

// ================ test for Lazy Prim mst ==============

//    string fileName = "testG1.txt";
//    int V = 8;
//
//    SparseGraph<double> g = SparseGraph<double>(V, false);
//    ReadGraph<SparseGraph<double>, double> readGraph(g, fileName);
//
//    cout << "Test Lazy Prim MST: " << endl;
//    LazyPrimMST<SparseGraph<double>, double> lazyPrimMst(g);
//    vector<Edge<double>> mst = lazyPrimMst.mstEdges();
//    for (int i = 0; i < mst.size(); i++) {
//        cout << mst[i] << endl;
//    }
//    cout << "The MST weight is: " << lazyPrimMst.result() << endl;
//    cout << endl;

// ================ test for Prim mst ==============
//    cout << "Test Prim MST: " << endl;
//    PrimMST<SparseGraph<double>, double> primMst(g);
//    mst = primMst.mstEdges();
//    for (int i = 0; i < mst.size(); i++) {
//        cout << mst[i] << endl;
//    }
//    cout << "The MST weight is: " << primMst.result() << endl;
//
//    cout << endl;


// ================ test for Kruskal mst ==============
//    cout << "Test Kruskal MST: " << endl;
//    KruskalMST<SparseGraph<double>, double> kruskalMst(g);
//    mst = kruskalMst.mstEdges();
//    for (int i = 0; i < mst.size(); i++) {
//        cout << mst[i] << endl;
//    }
//    cout << "The MST weight is: " << kruskalMst.result() << endl;
//
//    cout << endl;

// ================ test for Dijkstra ==============

    string fileName = "testDijG1.txt";
    int V = 5;

    SparseGraph<int> g = SparseGraph<int>(V, true);
    ReadGraph<SparseGraph<int>, int> readGraph(g, fileName);

    cout << "Test Dijkstra: " << endl << endl;
    Dijkstra<SparseGraph<int>, int> dijkstra(g, 0);
    for (int i = 1; i < V; i++) {
        cout << "Shortest path to " << i << " : " << dijkstra.shortestPathTo(i) << endl;
        dijkstra.showPath(i);
        cout << "-----------" << endl;
    }

    return 0;
}