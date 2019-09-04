package com.cunjunwang.algorithm.advanceddatastructure.union_find;

/**
 * Created by CunjunWang on 2019-09-03.
 */
public interface UnionFind {

    /**
     * 返回并查集当前元素数量
     *
     * @return 元素数量
     */
    int getSize();

    /**
     * id为p和id为q的元素是否相连
     *
     * @param p id
     * @param q id
     * @return 是否相连
     */
    boolean isConnected(int p, int q);

    /**
     * 将id为p和id为q的元素相连
     *
     * @param p id
     * @param q id
     */
    void unionElements(int p, int q);

}
