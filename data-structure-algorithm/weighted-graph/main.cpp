#include <iostream>
#include <iomanip>
#include <vector>
#include "Edge.h"
#include "DenseGraph.h"
#include "SparseGraph.h"
#include "ReadGraph.h"
#include "LazyPrimMST.h"
#include "PrimMST.h"

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

    string fileName = "testG1.txt";
    int V = 8;

    SparseGraph<double> g = SparseGraph<double>(V, false);
    ReadGraph<SparseGraph<double>, double> readGraph(g, fileName);

    cout << "Test Lazy Prim MST: " << endl;
    LazyPrimMST<SparseGraph<double>, double> lazyPrimMst(g);
    vector<Edge<double>> mst = lazyPrimMst.mstEdges();
    for (int i = 0; i < mst.size(); i++) {
        cout << mst[i] << endl;
    }
    cout << "The MST weight is: " << lazyPrimMst.result() << endl;
    cout << endl;

// ================ test for Prim mst ==============
    cout << "Test Prim MST: " << endl;
    PrimMST<SparseGraph<double>, double> primMst(g);
    mst = primMst.mstEdges();
    for (int i = 0; i < mst.size(); i++) {
        cout << mst[i] << endl;
    }
    cout << "The MST weight is: " << primMst.result() << endl;

    cout << endl;

    return 0;
}