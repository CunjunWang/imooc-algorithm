//
// Created by 王存俊 on 2019-07-11.
//

// 读取一个文件并形成一个图

#ifndef GRAPH_READGRAPH_H
#define GRAPH_READGRAPH_H

#include <iostream>
#include <string>
#include <fstream>
#include <sstream>
#include <cassert>

using namespace std;

template<typename Graph>
class ReadGraph {

public:
    ReadGraph(Graph &graph, const string &filename) {

        ifstream file(filename.c_str());
        string line;
        int V, E;

        assert(file.is_open());
        assert(getline(file, line));
        stringstream ss(line);
        ss >> V >> E;

        assert(V == graph.V());

        for (int i = 0; i < E; i++) {
            assert(getline(file, line));
            stringstream ss(line);

            int a, b;
            ss >> a >> b;
            assert(a >= 0 && a < V);
            assert(b >= 0 && b < V);
            graph.addEdge(a,b);
        }
    }

};

#endif //GRAPH_READGRAPH_H
