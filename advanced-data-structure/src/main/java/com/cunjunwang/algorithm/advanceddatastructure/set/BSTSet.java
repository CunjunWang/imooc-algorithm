package com.cunjunwang.algorithm.advanceddatastructure.set;

import com.cunjunwang.algorithm.advanceddatastructure.binary_search_tree.BST;

/**
 * 基于BST实现Set
 * Created by CunjunWang on 2019-07-31.
 */
public class BSTSet<E extends Comparable<E>> implements Set<E> {

    private BST<E> bst;

    public BSTSet() {
        bst = new BST<>();
    }

    /**
     * 获得集合元素数量
     *
     * @return 元素数量
     */
    @Override
    public int getSize() {
        return bst.size();
    }

    /**
     * 集合是否为空
     *
     * @return 是否为空
     */
    @Override
    public boolean isEmpty() {
        return bst.isEmpty();
    }

    /**
     * 添加元素, 不能有重复元素
     * O(h) h = height
     *
     * @param e 待添加元素
     */
    @Override
    public void add(E e) {
        bst.add(e);
    }

    /**
     * 删除元素
     * O(h) h = height
     *
     * @param e 待删除元素
     */
    @Override
    public void remove(E e) {
        bst.remove(e);
    }

    /**
     * 判断是否包含某元素
     * O(h) h = height
     *
     * @param e 元素
     * @return 是否包含
     */
    @Override
    public boolean contains(E e) {
        return bst.contains(e);
    }

}
