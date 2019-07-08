//
// Created by 王存俊 on 2019-07-08.
//

// Quick Union

#ifndef UNION_FIND_UNIONFIND2_H
#define UNION_FIND_UNIONFIND2_H

#include <cassert>

namespace UF2 {

    class UnionFind {
    private:
        int *parent;
        int count;

    public:
        UnionFind(int count) {
            parent = new int[count];
            this->count = count;
            for (int i = 0; i < count; i++) {
                parent[i] = i;
            }
        }

        ~UnionFind() {
            delete[] parent;
        }

        int find(int p) {
            assert(p >= 0 && p < count);
            while (p != parent[p]) {
                p = parent[p];
            }
            return p;
        }

        bool isConnected(int p, int q) {
            return find(p) == find(q);
        }

        void unionElements(int p, int q) {
            int pRoot = find(p);
            int qRoot = find(q);

            if (pRoot == qRoot) {
                return;
            }

            parent[pRoot] = qRoot;
        }
    };

}

#endif //UNION_FIND_UNIONFIND2_H
