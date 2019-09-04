package com.cunjunwang.algorithm.advanceddatastructure.union_find;

/**
 * 第一版并查集, 快速查找
 * Created by CunjunWang on 2019-09-03.
 */
public class UnionFindQuickFind implements UnionFind {

    private int[] id;

    public UnionFindQuickFind(int size) {
        id = new int[size];

        // 初始化：每个元素对应的集合编号都不一样
        // 即最开始都没有相连
        for (int i = 0; i < id.length; i++) {
            id[i] = i;
        }
    }

    /**
     * 返回并查集当前元素数量
     *
     * @return 元素数量
     */
    @Override
    public int getSize() {
        return id.length;
    }

    /**
     * id为p和id为q的元素是否相连(属于同一个集合)
     * O(1)
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
     *
     * @param p id
     * @param q id
     */
    @Override
    public void unionElements(int p, int q) {
        int pID = find(p);
        int qID = find(q);

        if (pID == qID) {
            return;
        } else {
            for (int i = 0; i < id.length; i++) {
                if (id[i] == pID) {
                    id[i] = qID; // 也可以颠倒
                }
            }
        }
    }

    /**
     * 返回元素p对应的集合编号
     * O(1)
     *
     * @param p id
     * @return 集合编号
     */
    private int find(int p) {
        if (p < 0 || p >= id.length)
            throw new IllegalArgumentException("p is out od bound");
        return id[p];
    }
}
