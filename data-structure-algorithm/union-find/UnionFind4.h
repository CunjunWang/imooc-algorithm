//
// Created by 王存俊 on 2019-07-09.
//

// 基于rank的优化
// 根据层数决定把哪个合并到另一个上
// 并查集的层数叫做rank

#ifndef UNION_FIND_UNIONFIND4_H
#define UNION_FIND_UNIONFIND4_H

#include <cassert>

using namespace std;

namespace UF4 {

    class UnionFind {

    private:
        int *parent;
        int *rank; // rank[i]表示以i为根的集合所表示的树的层数
        int count;

    public:
        UnionFind(int count) {
            parent = new int[count];
            rank = new int[count];
            this->count = count;
            for (int i = 0; i < count; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }

        ~UnionFind() {
            delete[] parent;
            delete[] rank;
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

            if (rank[pRoot] < rank[qRoot]) {
                parent[pRoot] = qRoot;
            } else if (rank[qRoot] < rank[pRoot]) {
                parent[qRoot] = pRoot;
            } else {
                // rank[qRoot] == rank[pRoot]
                parent[pRoot] = qRoot;
                rank[qRoot] += 1;
            }
        }
    };
}


#endif //UNION_FIND_UNIONFIND4_H
