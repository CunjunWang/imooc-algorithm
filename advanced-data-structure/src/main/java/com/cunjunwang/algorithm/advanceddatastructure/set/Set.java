package com.cunjunwang.algorithm.advanceddatastructure.set;

/**
 * 集合接口
 * Created by CunjunWang on 2019-07-31.
 */
public interface Set<E> {

    /**
     * 添加元素, 不能有重复元素
     *
     * @param e 待添加元素
     */
    void add(E e);

    /**
     * 删除元素
     *
     * @param e 待删除元素
     */
    void remove(E e);

    /**
     * 判断是否包含某元素
     *
     * @param e 元素
     * @return 是否包含
     */
    boolean contains(E e);

    /**
     * 获得集合元素数量
     *
     * @return 元素数量
     */
    int getSize();

    /**
     * 集合是否为空
     *
     * @return 是否为空
     */
    boolean isEmpty();
}
