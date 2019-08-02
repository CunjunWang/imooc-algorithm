package com.cunjunwang.algorithm.advanceddatastructure.heap;

import com.cunjunwang.algorithm.advanceddatastructure.queue.Queue;

/**
 * 基于heap实现
 * Created by CunjunWang on 2019-08-02.
 */
public class PriorityQueue<E extends Comparable<E>> implements Queue<E> {

    private MaxHeap<E> maxHeap;

    public PriorityQueue () {
        maxHeap = new MaxHeap<>();
    }

    /**
     * 队列大小
     *
     * @return 元素个数
     */
    @Override
    public int getSize() {
        return maxHeap.size();
    }

    /**
     * 是否为空
     *
     * @return 是否为空
     */
    @Override
    public boolean isEmpty() {
        return maxHeap.isEmpty();
    }

    /**
     * 查看队首元素
     * 对于优先队列也就是最大元素
     *
     * @return 队首元素
     */
    @Override
    public E getFront() {
        return maxHeap.findMax();
    }

    /**
     * 入队
     *
     * @param e 元素
     */
    @Override
    public void enqueue(E e) {
        maxHeap.add(e);
    }

    /**
     * 出队
     *
     * @return 队首元素
     */
    @Override
    public E dequeue() {
        return maxHeap.extractMax();
    }

}
