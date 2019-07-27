package com.cunjunwang.algorithm.advanceddatastructure.queue;

/**
 * Created by CunjunWang on 2019-07-27.
 */
public interface Queue<E> {

    /**
     * 入队
     *
     * @param e 元素
     */
    void enqueue(E e);

    /**
     * 出队
     *
     * @return 队首元素
     */
    E dequeue();

    /**
     * 查看队首元素
     *
     * @return 队首原色
     */
    E getFront();

    /**
     * 队列大小
     *
     * @return 元素个数
     */
    int getSize();

    /**
     * 是否为空
     *
     * @return 是否为空
     */
    boolean isEmpty();

}
