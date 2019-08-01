package com.cunjunwang.algorithm.advanceddatastructure.set;

import com.cunjunwang.algorithm.advanceddatastructure.linked_list.LinkedList;

/**
 * 基于链表实现集合
 * Created by CunjunWang on 2019-07-31.
 */
public class LinkedListSet<E> implements Set<E> {

    private LinkedList<E> list;

    public LinkedListSet() {
        list = new LinkedList<>();
    }

    /**
     * 获得集合元素数量
     *
     * @return 元素数量
     */
    @Override
    public int getSize() {
        return list.getSize();
    }

    /**
     * 集合是否为空
     *
     * @return 是否为空
     */
    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    /**
     * 判断是否包含某元素
     * O(n)
     *
     * @param e 元素
     * @return 是否包含
     */
    @Override
    public boolean contains(E e) {
        return list.contains(e);
    }

    /**
     * 添加元素, 不能有重复元素
     * O(n)
     *
     * @param e 待添加元素
     */
    @Override
    public void add(E e) {
        if (!list.contains(e)) {
            list.addFirst(e);
        }
    }

    /**
     * 删除元素
     * O(n)
     *
     * @param e 待删除元素
     */
    @Override
    public void remove(E e) {
        list.removeElement(e);
    }

}
