package com.cunjunwang.algorithm.advanceddatastructure.union_find;

/**
 * 基于size优化，把深度小的树合并到深度大的树
 * Created by CunjunWang on 2019-09-03.
 */
public class UnionFindOptSize implements UnionFind {
    private int[] parent;
    private int[] sz; // height[i] 表示以i为root的集合中元素个数

    public UnionFindOptSize(int size) {
        parent = new int[size];
        sz = new int[size];
        // 初始时, 每一个节点的parent都是自己, 独立成树
        for (int i = 0; i < size; i++) {
            parent[i] = i;
            sz[i] = 1;
        }
    }

    /**
     * 返回并查集当前元素数量
     *
     * @return 元素数量
     */
    @Override
    public int getSize() {
        return parent.length;
    }

    /**
     * id为p和id为q的元素是否相连
     * O(h)
     *
     * @param p id
     * @param q id
     * @return 是否相连
     */
    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    /**
     * 将id为p和id为q的元素相连
     * O(h)
     *
     * @param p id
     * @param q id
     */
    @Override
    public void unionElements(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot)
            return;
        else {
            // 基于size的优化
            if (sz[pRoot] < sz[qRoot]) {
                parent[pRoot] = qRoot;
                sz[qRoot] += sz[pRoot];
            } else {
                parent[qRoot] = pRoot;
                sz[pRoot] += sz[qRoot];
            }
        }

    }

    /**
     * 找到p所在的集合
     * 思路：从当前的p开始, 不断地找p的parent
     * 直到parent为自己了, 遇到了root
     * O(h), h = p所在节点的树的高度
     *
     * @param p p
     * @return p所在集合
     */
    private int find(int p) {
        if (p < 0 || p >= parent.length)
            throw new IllegalArgumentException("p is out of bound");
        while (p != parent[p]) {
            p = parent[p];
        }
        return p;
    }
}
