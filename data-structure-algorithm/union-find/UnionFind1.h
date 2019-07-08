//
// Created by 王存俊 on 2019-07-08.
//

#ifndef UNION_FIND_UNIONFIND1_H
#define UNION_FIND_UNIONFIND1_H

#include <iostream>
#include <cassert>

using namespace std;

namespace UF1 {

    class UnionFind {

    private:
        int *id;
        int count;

    public:
        UnionFind(int n) {
            count = n;
            id = new int[n];
            for (int i = 0; i < n; i++) {
                id[i] = i;
            }
        }

        ~UnionFind() {
            delete[] id;
        }

        int find(int p) {
            assert(p >= 0 && p < count);
            return id[p];
        }

        bool isConnected(int p, int q) {
            return find(p) == find(q);
        }

        void unionElements(int p, int q) {
            int pId = find(p);
            int qId = find(q);
            if (pId == qId) {
                return;
            }
            for (int i = 0; i < count; i++) {
                if (id[i] == pId) {
                    id[i] = qId;
                }
            }
        }
    };
}

#endif //UNION_FIND_UNIONFIND1_H
