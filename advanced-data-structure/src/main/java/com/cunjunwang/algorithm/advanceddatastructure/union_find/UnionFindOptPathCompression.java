package com.cunjunwang.algorithm.advanceddatastructure.union_find;

/**
 * 优化路径压缩
 * Created by CunjunWang on 2019-09-03.
 */
public class UnionFindOptPathCompression implements UnionFind {
    private int[] parent;
    private int[] rank; // rank[i] 表示以i为root的树的高度

    public UnionFindOptPathCompression(int size) {
        parent = new int[size];
        rank = new int[size];
        // 初始时, 每一个节点的parent都是自己, 独立成树
        for (int i = 0; i < size; i++) {
            parent[i] = i;
            rank[i] = 1;
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

        // 基于rank的优化
        if (rank[pRoot] < rank[qRoot]) {
            parent[pRoot] = qRoot;
        } else if (rank[qRoot] < rank[pRoot]) {
            parent[qRoot] = pRoot;
        } else {
            // 两个子树高度相等时, 需要维护rank
            parent[qRoot] = pRoot;
            rank[pRoot]++;
        }
    }

    /**
     * 找到p所在的集合
     * 思路：从当前的p开始, 不断地找p的parent
     * 直到parent为自己了, 遇到了root
     * O(h), h = p所在节点的树的高度
     * <p>
     * // 添加路径压缩
     *
     * @param p p
     * @return p所在集合
     */
    private int find(int p) {
        if (p < 0 || p >= parent.length)
            throw new IllegalArgumentException("p is out of bound");
        if (p != parent[p]) {
            parent[p] = find(parent[p]);
        }
        return parent[p];
    }
}
