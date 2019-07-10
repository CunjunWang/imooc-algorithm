//
// Created by 王存俊 on 2019-07-09.
//

// 基于size的优化
// 把size较小的集合union到size较大的集合

#ifndef UNION_FIND_UNIONFIND3_H
#define UNION_FIND_UNIONFIND3_H

#include <cassert>

using namespace std;

namespace UF3 {

    class UnionFind {

    private:
        int *parent;
        int *sz; // sz[i]表示以i为根的集合中的元素个数
        int count;

    public:
        UnionFind(int count) {
            parent = new int[count];
            sz = new int[count];
            this->count = count;
            for (int i = 0; i < count; i++) {
                parent[i] = i;
                sz[i] = 1;
            }
        }

        ~UnionFind() {
            delete[] parent;
            delete[] sz;
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

            if (sz[pRoot] < sz[qRoot]) {
                parent[pRoot] = qRoot;
                sz[qRoot] += sz[pRoot];
            } else {
                parent[qRoot] = pRoot;
                sz[pRoot] += sz[qRoot];
            }
        }
    };
}

#endif //UNION_FIND_UNIONFIND3_H