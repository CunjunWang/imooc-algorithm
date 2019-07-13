#include <iostream>
#include "SparseGraph.h"
#include "DenseGraph.h"
#include "ReadGraph.h"
#include "Component.h"
#include "FindPath.h"

using namespace std;

int main() {
// =================== test for building graph ===================
//    int N = 20;
//    int M = 100;
//
//    srand(time(NULL));
//
//    // Sparse Graph
//    SparseGraph g1(N, false);
//    for (int i = 0; i < M; i++) {
//        int a = rand() % N;
//        int b = rand() % N;
//        g1.addEdge(a, b);
//    }
//
//    // O(E)
//    for (int v = 0; v < N; v++) {
//        cout << v << " : ";
//        SparseGraph::adjacentIterator iterator(g1, v);
//        for (int w = iterator.begin(); !iterator.end(); w = iterator.next()) {
//            cout << w << " ";
//        }
//        cout << endl;
//    }
//
//    cout << endl;
//
//    // Dense Graph
//    DenseGraph g2(N, false);
//    for (int i = 0; i < M; i++) {
//        int a = rand() % N;
//        int b = rand() % N;
//        g2.addEdge(a, b);
//    }
//
//    // O(V^2)
//    for (int v = 0; v < N; v++) {
//        cout << v << " : ";
//        DenseGraph::adjacentIterator iterator(g2, v);
//        for (int w = iterator.begin(); !iterator.end(); w = iterator.next()) {
//            cout << w << " ";
//        }
//        cout << endl;
//    }

// ================== test for reading a graph file ===================

//    string fileName = "testG1.txt";
//    SparseGraph g1(13, false);
//    ReadGraph<SparseGraph> readGraph1(g1, fileName);
//    cout << "test G1 in Sparse Graph: " << endl;
//    g1.show();
//
//    cout << endl;
//
//    DenseGraph g2(13, false);
//    ReadGraph<DenseGraph> readGraph2(g2, fileName);
//    cout << "test G2 in Dense Graph: " << endl;
//    g2.show();
//
//    cout << endl;
//
//    // 使用两种图的存储方式读取testG2.txt文件
//    fileName = "testG2.txt";
//    SparseGraph g3(6, false);
//    ReadGraph<SparseGraph> readGraph3(g3, fileName);
//    cout << "test G2 in Sparse Graph:" << endl;
//    g3.show();
//
//    cout << endl;
//
//    DenseGraph g4(6, false);
//    ReadGraph<DenseGraph> readGraph4(g4, fileName);
//    cout << "test G2 in Dense Graph:" << endl;
//    g4.show();


// ================== test for finding connect components ===================
//    string fileName1 = "testG1.txt";
//    SparseGraph g1 = SparseGraph(13, false);
//    ReadGraph<SparseGraph> readGraph1(g1, fileName1);
//    Component<SparseGraph> component1(g1);
//    cout << "Test G1, Component count: " << component1.count() << endl;
//
//    cout << endl;
//
//    string fileName2 = "testG2.txt";
//    SparseGraph g2 = SparseGraph(6, false);
//    ReadGraph<SparseGraph> readGraph2(g2, fileName2);
//    Component<SparseGraph> component2(g2);
//    cout << "Test G2, Component count: " << component2.count() << endl;

// ================== test for finding paths ===================
    string fileName = "testG2.txt";
    SparseGraph g = SparseGraph(6, false);
    ReadGraph<SparseGraph> readGraph(g, fileName);
    g.show();
    cout << endl;

    FindPath<SparseGraph> DFS(g, 0);
    cout << "DFS : ";
    DFS.showPath(2);

    return 0;

}